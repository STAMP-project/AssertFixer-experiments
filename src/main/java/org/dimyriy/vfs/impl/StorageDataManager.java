package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.*;
import static org.dimyriy.vfs.impl.constants.StorageConstants.directoryAttribute;
import static org.dimyriy.vfs.impl.constants.StorageConstants.fileAttribute;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
@NotThreadSafe
public class StorageDataManager implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageDataManager.class);
  private final BoundStorageReaderWriter dataSectorAccessor;
  private final StorageMetadataManager metadataManager;
  private final StorageFatManager fatManager;
  private final long initialOffset;
  private final int clusterSize;

  StorageDataManager(@Nonnull final File file, @Nonnull final StorageMetadataManager metadataManager, @Nonnull final Storage.Configuration configuration) {
    this.metadataManager = metadataManager;
    this.clusterSize = configuration.getClusterSizeInBytes();
    final PositiveLongRange accessRange = StorageConstants.dataSectorRange(configuration.getNumberOfClusters(), clusterSize);
    this.dataSectorAccessor = new BoundStorageReaderWriter(file, accessRange, configuration.getDataReadersPoolSize());
    this.fatManager = new StorageFatManager(file, configuration);
    this.initialOffset = accessRange.getLowerBoundClosed();
  }

  @Override
  public void close() throws IOException {
    LOGGER.trace("Closing StorageDataManager started");
    final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
    LOGGER.trace("Closing fatManager");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, fatManager);
    LOGGER.trace("Closing dataSectorAccessor");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, dataSectorAccessor);
    if (thrown.getValue() != null) {
      LOGGER.warn("Closing StorageDataManager failed", thrown.getValue());
      throw thrown.getValue();
    }
    LOGGER.trace("Closing StorageDataManager finished");
  }

  int getFreeSpace() {
    return fatManager.getNumberOfEmptyClusters() * clusterSize;
  }

  void processCorruptedEntry(final StorageEntryHeader header) {
    LOGGER.trace("Processing corrupted entry {} started", header);
    if (header.getStartingCluster() != FileAllocationTableConstants.BAD_CLUSTER) {
      fatManager.executeTransactional(() -> {
        final OffsetRwState rwState = new OffsetRwState(header.getFileSize(), header.getStartingCluster(), 0);
        final List<Integer> corruptedClusters = new ArrayList<>();
        while (rwState.remainingBytes > 0 &&
          !FileAllocationTableConstants.isBadCluster(rwState.currentCluster) &&
          !FileAllocationTableConstants.isEmptyCluster(rwState.currentCluster)) {
          corruptedClusters.add(rwState.currentCluster);
          rwState.currentCluster = fatManager.getValueOfCluster(rwState.currentCluster);
          rwState.remainingBytes -= clusterSize;
        }
        final int[] corrupted = new int[corruptedClusters.size()];
        for (int i = 0; i < corruptedClusters.size(); i++) {
          corrupted[i] = corruptedClusters.get(i);
        }
        LOGGER.trace("Processing corrupted entry {} setting bad clusters {}", header, corruptedClusters);
        fatManager.setBadClusters(corrupted);
        LOGGER.trace("Processing corrupted entry {} setting StorageEntryHeader.startingCluster to bad cluster", header);
        header.setStartingCluster(FileAllocationTableConstants.badCluster());
        header.rewrite(header.getFilename(), this);
      });
    }
    LOGGER.trace("Processing corrupted entry {} finished", header);
  }

  void repairCorruptedClusters() {
    LOGGER.trace("Repairing corrupted clusters started");
    fatManager.executeTransactional(fatManager::clearBadClusters);
    LOGGER.trace("Processing corrupted entry finished");
  }

  void updateRootDirectoryHeader() {
    this.metadataManager.flushMetadata();
  }

  void deleteChild(@Nonnull final StorageEntryHeader parent, @Nonnull final StorageEntryHeader entry) {
    final int startingCluster = entry.getStartingCluster();
    final int index = parent.locateChildByFilenameSafely(entry.getFilename(), this);
    final byte[] parentHeadersList = readData(parent.getFileSize(), startingCluster);
    fatManager.executeTransactional(() -> {
      writeContent(parent, ByteUtil.compact(parentHeadersList, 0, index, headerByteSize()));
      parent.setFileSize(parent.getFileSize() - StorageEntryHeader.sizeInBytes());
      if (!(parent instanceof StorageEntryHeader.RootDirectoryHeader)) {
        int nextCluster = startingCluster;
        while (!isEmptyCluster(nextCluster)) {
          nextCluster = fatManager.clearCluster(nextCluster);
        }
      }
    });
  }

  StorageEntryHeader createEmptyChildInDirectory(@Nonnull final StorageEntryHeader directoryHeader,
                                                 @Nonnull final byte[] filename,
                                                 final boolean isDirectory) {
    Assertions.entryHeaderIsDirectory(directoryHeader);
    Assertions.directorySizeIsNotExceeded(directoryHeader.getFileSize() + StorageEntryHeader.sizeInBytes());
    final byte attribute = isDirectory ? directoryAttribute() : fileAttribute();
    assertChildDoesNotExist(directoryHeader, filename);
    return fatManager.createTransactional(() -> {
      if (directoryHeader.isEmpty()) {
        directoryHeader.setStartingCluster(fatManager.getNextFreeCluster(emptyCluster()));
      }
      final StorageEntryHeader newEntry = new StorageEntryHeader(attribute,
                                                                 filename,
                                                                 emptyCluster(),
                                                                 0,
                                                                 SystemUtil.currentTS(),
                                                                 directoryHeader.getStartingCluster());
      final int headerOffset = directoryHeader.getFileSize();
      directoryHeader.setFileSize(directoryHeader.getFileSize() + StorageEntryHeader.sizeInBytes());
      directoryHeader.setModificationUnixTime(SystemUtil.currentTS());
      final byte[] content = newEntry.toByteArray();
      appendContent(newEntry.toByteArray(), new OffsetRwState(content.length, directoryHeader.getStartingCluster(), headerOffset));
      directoryHeader.rewrite(directoryHeader.getFilename(), this);
      return newEntry;
    });
  }

  void writeContentTransactional(@Nonnull final StorageEntryHeader header, @Nonnull final byte[] content) {
    fatManager.executeTransactional(() -> writeContent(header, content));
  }

  byte[] readData(final OffsetRwState offsetReadParameter, final boolean assertUnderflow) {
    if (isEmptyCluster(offsetReadParameter.currentCluster)) {
      return new byte[0];
    }
    if (isBadCluster(offsetReadParameter.currentCluster)) {
      throw new MalformedContentException();
    }
    final ByteBuffer b = ByteBuffer.allocate(offsetReadParameter.remainingBytes);
    offsetReadParameter.skipOffsetClusters(clusterSize, assertUnderflow, fatManager);
    while (offsetReadParameter.remainingBytes + offsetReadParameter.remainingOffset >= clusterSize) {
      if (assertUnderflow) {
        offsetReadParameter.assertUnderflow();
      }
      readFromOneClusterWithOffsetToBuffer(offsetReadParameter, clusterSize, b);
    }
    if (assertUnderflow) {
      offsetReadParameter.assertUnderflow();
    }
    readFromOneClusterWithOffsetToBuffer(offsetReadParameter, offsetReadParameter.remainingBytes, b);
    return b.array();
  }

  byte[] readData(final int fileSize, final int startingCluster) {
    return readData(new OffsetRwState(fileSize, startingCluster, 0), true);
  }

  StorageEntryHeader traverseFromRoot(@Nonnull final Stream<byte[]> pathWalker) {
    final SimpleObjectHolder<StorageEntryHeader> currentHeader = new SimpleObjectHolder<>(metadataManager.getRootDirectory());
    for (final Iterator<byte[]> walkingIterator = pathWalker.iterator(); walkingIterator.hasNext(); ) {
      final StorageEntryHeader value = currentHeader.getValue();
      if (value == null) {
        throw new StorageEntryHeaderNotFoundException();
      } else if (!value.isDirectory() && walkingIterator.hasNext()) {
        throw new StorageRecordDoesNotExistException();
      } else {
        try {
          final StorageEntryHeader child = currentHeader.getValue().getChild(walkingIterator.next(), this);
          currentHeader.setValue(child);
        } catch (final StorageEntryHeaderNotFoundException e) {
          throw new StorageRecordDoesNotExistException();
        }
      }
    }
    return currentHeader.getValue();
  }

  List<StorageEntryHeader> readDirectoryChildren(@Nonnull final StorageEntryHeader directoryHeader) {

    if (directoryHeader.numberOfChildStorageEntries() == 0) {
      return Collections.emptyList();
    }
    final byte[] directoryContent = readData(directoryHeader.getFileSize(), directoryHeader.getStartingCluster());
    final List<StorageEntryHeader> storageEntryHeaders = new ArrayList<>(directoryHeader.numberOfChildStorageEntries());
    for (int i = 0; i < directoryHeader.getFileSize(); i += StorageEntryHeader.sizeInBytes()) {
      storageEntryHeaders.add(StorageEntryHeader.fromByteArray(directoryContent, i));
    }
    return storageEntryHeaders;
  }

  void appendContent(@Nonnull final byte[] content, @Nonnull final OffsetRwState writeParameter) {
    writeParameter.skipOffsetClusters(clusterSize, true, fatManager);
    while (writeParameter.remainingBytes + writeParameter.remainingOffset >= clusterSize) {
      final byte[] chunk = new byte[clusterSize];
      System.arraycopy(content, content.length - writeParameter.remainingBytes, chunk, 0, clusterSize);
      writeToOneClusterWithOffsetFromBuffer(writeParameter, chunk);
    }
    final byte[] chunk = new byte[writeParameter.remainingBytes];
    System.arraycopy(content, content.length - writeParameter.remainingBytes, chunk, 0, writeParameter.remainingBytes);
    writeToOneClusterWithOffsetFromBuffer(writeParameter, chunk);
  }

  private void readFromOneClusterWithOffsetToBuffer(@Nonnull final OffsetRwState offsetReadParameter,
                                                    final int bytesToRead, @Nonnull final ByteBuffer b) {
    b.put(dataSectorAccessor.read(calculateOffset(offsetReadParameter.currentCluster) + offsetReadParameter.remainingOffset, bytesToRead));
    offsetReadParameter.currentCluster = fatManager.getValueOfCluster(offsetReadParameter.currentCluster);
    offsetReadParameter.remainingBytes -= bytesToRead;
    offsetReadParameter.remainingOffset = 0;
  }

  private void writeToOneClusterWithOffsetFromBuffer(@Nonnull final OffsetRwState writeParameter,
                                                     @Nonnull final byte[] content) {
    dataSectorAccessor.write(calculateOffset(writeParameter.currentCluster) + writeParameter.remainingOffset, content);
    writeParameter.remainingBytes -= content.length;
    if (writeParameter.remainingBytes > 0) {
      writeParameter.currentCluster = fatManager.getNextFreeCluster(writeParameter.currentCluster);
    }
    writeParameter.remainingOffset = 0;
  }

  private void writeContent(@Nonnull final StorageEntryHeader header, @Nonnull final byte[] content) {
    header.setFileSize(content.length);
    header.setModificationUnixTime(SystemUtil.currentTS());
    if (isEmptyCluster(header.getStartingCluster())) {
      header.setStartingCluster(fatManager.getNextFreeCluster(emptyCluster()));
      header.rewrite(header.getFilename(), this);
    }
    appendContent(content, new OffsetRwState(content.length, header.getStartingCluster(), 0));
  }

  private void assertChildDoesNotExist(@Nonnull final StorageEntryHeader directoryHeader, @Nonnull final byte[] filename) {
    if (directoryHeader.childExists(filename, this)) {
      throw new StorageRecordAlreadyExistsException();
    }
  }

  private long calculateOffset(final int clusterNumber) {
    return initialOffset + clusterNumber * clusterSize;
  }

  static class OffsetRwState {
    int remainingBytes;
    int currentCluster;
    int remainingOffset;

    OffsetRwState(final int remainingBytes, final int currentCluster, final int remainingOffset) {
      this.remainingBytes = remainingBytes;
      this.currentCluster = currentCluster;
      this.remainingOffset = remainingOffset;
    }

    void skipOffsetClusters(final int clusterSize, final boolean assertUnderflow, final StorageFatManager fatManager) {
      while (remainingOffset >= clusterSize) {
        if (assertUnderflow) {
          assertUnderflow();
        }
        currentCluster = fatManager.getValueOfCluster(currentCluster);
        remainingOffset -= clusterSize;
      }
    }

    private void assertUnderflow() {
      if (isBadCluster(currentCluster) || isEmptyCluster(currentCluster)) {
        throw new StorageClusterUnderflowException();
      }
    }
  }
}
