package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.MalformedContentException;
import org.dimyriy.vfs.impl.exceptions.StorageClosingResourceFailedException;
import org.dimyriy.vfs.impl.exceptions.StorageClusterOverflowException;
import org.dimyriy.vfs.impl.exceptions.StorageEntryHeaderNotFoundException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.EMPTY_CLUSTER;
import static org.dimyriy.vfs.impl.constants.StorageConstants.CLUSTER_LENGTH_IN_BYTES;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
@ThreadSafe
public class StorageDataManager implements AutoCloseable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageDataManager.class);
  private final GuardedReaderWriter guardedReaderWriter = new GuardedReaderWriter();
  private final BoundStorageReaderWriter dataSectorAccessor;
  private final StorageMetadataManager metadataManager;
  private final StorageFatManager fatManager;
  private final long initialOffset;

  StorageDataManager(@Nonnull final File file, @Nonnull final StorageMetadataManager metadataManager, @Nonnull final Storage.Configuration configuration) {
    this.metadataManager = metadataManager;
    final PositiveLongRange accessRange = StorageConstants.dataSectorRange(metadataManager.numberOfClusters());
    this.dataSectorAccessor = new BoundStorageReaderWriter(file, accessRange);
    this.fatManager = new StorageFatManager(file, metadataManager.numberOfClusters(), configuration);
    this.initialOffset = accessRange.getLowerBoundClosed();
  }

  @Override
  public void close() {
    guardedReaderWriter.executeWriteOperation(() -> {
      StorageClosingResourceFailedException thrown = null;
      try {
        fatManager.close();
      } catch (final Exception e) {
        LOGGER.warn("Closing storage fat manager failed with exception", e);
        thrown = new StorageClosingResourceFailedException(e);
      } finally {
        try {
          dataSectorAccessor.close();
        } catch (final Exception e) {
          LOGGER.warn("Closing data sector accessor failed with exception", e);
          if (thrown == null) {
            thrown = new StorageClosingResourceFailedException(e);
          } else {
            thrown.addSuppressed(e);
          }
        }
      }
      if (thrown != null) {
        throw thrown;
      }
    });
  }

  StorageEntryHeader createEmptyChildInDirectory(@Nonnull final StorageEntryHeader directory,
                                                 @Nonnull final AbstractStorageRecordImpl record) {
    return guardedReaderWriter.executeCreateOperation(() -> {
      Assertions.entryHeaderDirectory(directory);
      Assertions.assertDirectorySize(directory.getFileSize() + StorageEntryHeader.length());
      final StorageEntryHeader storageEntryHeader = new StorageEntryHeader(ByteUtil.asciiStringToByteArray(record.getFilename()),
                                                                           EMPTY_CLUSTER,
                                                                           0,
                                                                           SystemUtil.currentTS(),
                                                                           record.getAttribute());
      final int headerOffset = directory.getFileSize();
      directory.setFileSize(directory.getFileSize() + StorageEntryHeader.length());
      directory.setModificationUnixTime(SystemUtil.currentTS());
      writeClusterContentAtOffset(storageEntryHeader.toByteArray(), directory.getStartingCluster(), headerOffset);
      rewriteStorageEntryHeader(record.getPath(), directory.getFilename(), directory);
      return storageEntryHeader;
    });
  }

  void writeContent(@Nonnull final StorageEntryHeader header, @Nonnull final byte[] content) {
    guardedReaderWriter.executeWriteOperation(() -> {
      if (header.getStartingCluster() == EMPTY_CLUSTER) {
        header.setStartingCluster(fatManager.getNextFreeCluster(EMPTY_CLUSTER));
      }
      header.setFileSize(content.length);
      header.setModificationUnixTime(SystemUtil.currentTS());
      appendContent(content, header.getStartingCluster(), 0);
    });
  }

  @GuardedBy("guardedReaderWriter.guard.readLock")
  byte[] readDataAtOffset(final int length, final int clusterNumber, final int offset) {
    if (offset >= CLUSTER_LENGTH_IN_BYTES) {
      throw new StorageClusterOverflowException();
    }
    return guardedReaderWriter.executeReadOperation(() -> {
      final ByteBuffer b = ByteBuffer.allocate(length);
      int remainingFileSize = length;
      int currentCluster = clusterNumber;
      while (remainingFileSize > CLUSTER_LENGTH_IN_BYTES) {
        if (currentCluster == EMPTY_CLUSTER) {
          throw new MalformedContentException();
        }
        b.put(dataSectorAccessor.read(calculateOffset(currentCluster), CLUSTER_LENGTH_IN_BYTES));
        currentCluster = fatManager.getNextCluster(currentCluster);
        remainingFileSize -= CLUSTER_LENGTH_IN_BYTES;
      }
      b.put(dataSectorAccessor.read(calculateOffset(clusterNumber) + offset, length));
      return b.array();
    });
  }

  @GuardedBy("guardedReaderWriter.guard.readLock")
  byte[] readData(final int fileSize, final int startingCluster) {
    return readDataAtOffset(fileSize, startingCluster, 0);
  }

  @GuardedBy("guardedReaderWriter.guard.writeLock")
  private void rewriteStorageEntryHeader(@Nonnull final StoragePath path,
                                         @Nonnull final byte[] oldFilename,
                                         @Nonnull final StorageEntryHeader newStorageEntryHeader) {
    if (newStorageEntryHeader instanceof StorageEntryHeader.RootDirectoryHeader) {
      metadataManager.updateRootDirectoryHeader();
    } else {
      final StorageEntryHeader.EntryWithIndex headerDescriptor = find(path, oldFilename);
      if (headerDescriptor != null) {
        writeClusterContentAtOffset(newStorageEntryHeader.toByteArray(), headerDescriptor.getStorageEntryHeader().getStartingCluster(),
                                    storageHeaderDirectoryChildOffsetInBytes(headerDescriptor.getIndex()));
      } else {
        LOGGER.warn("Header descriptor not found for path {} and filename {}", path, oldFilename);
        throw new StorageEntryHeaderNotFoundException("Path: " + path + "; filename: " + new String(ByteUtil.toAsciiCharArray(oldFilename)));
      }
    }
  }

  @GuardedBy("guardedReaderWriter.guard")
  private StorageEntryHeader.EntryWithIndex find(@Nonnull final StoragePath directory, @Nonnull final byte[] filename) {
    if (directory.isRoot()) {
      return getChildHeaderByName(metadataManager.getRootDirectory(), filename);
    }
    StorageEntryHeader.EntryWithIndex storageEntryHeader = new StorageEntryHeader.EntryWithIndex(metadataManager.getRootDirectory(), -1);
    for (final Iterator<String> childIterator = directory.pathWalker().iterator(); childIterator.hasNext(); ) {
      final String childName = childIterator.next();
      storageEntryHeader = getChildHeaderByName(storageEntryHeader.getStorageEntryHeader(),
                                                ByteUtil.asciiStringToByteArray(childName));
      if (storageEntryHeader == null || storageEntryHeader.getStorageEntryHeader().isDirectory()) {
        throw new StorageEntryHeaderNotFoundException(directory.toString());
      }
    }
    return storageEntryHeader;
  }

  @GuardedBy("guardedReaderWriter.guard")
  private StorageEntryHeader.EntryWithIndex getChildHeaderByName(@Nonnull final StorageEntryHeader directory, @Nonnull final byte[] filename) {
    for (int i = 0; i < directory.numberOfChildStorageEntries(); i++) {
      if (Arrays.equals(filename, directory.readFilenameOfEntry(i, this))) {
        return new StorageEntryHeader.EntryWithIndex(directory.readEntryAtIndex(i, this), i);
      }
    }
    return null;
  }

  @GuardedBy("guardedReaderWriter.guard.writeLock")
  private void writeClusterContentAtOffset(final byte[] newContent,
                                           final int clusterNumber,
                                           final int storageHeaderDirectoryChildOffsetInBytes) {
    if (storageHeaderDirectoryChildOffsetInBytes + newContent.length > CLUSTER_LENGTH_IN_BYTES) {
      throw new StorageClusterOverflowException();
    }
    appendContent(newContent, clusterNumber, storageHeaderDirectoryChildOffsetInBytes);
  }

  @GuardedBy("guardedReaderWriter.guard.writeLock")
  private void appendContent(@Nonnull final byte[] content, final int startingCluster, final int initialOffset) {
    if (initialOffset >= CLUSTER_LENGTH_IN_BYTES) {
      throw new StorageClusterOverflowException();
    }
    if (content.length <= CLUSTER_LENGTH_IN_BYTES) {
      dataSectorAccessor.write(calculateOffset(startingCluster) + initialOffset, content);
    } else {
      int currentCluster = startingCluster;
      int remainingContent = content.length;
      while (remainingContent >= CLUSTER_LENGTH_IN_BYTES) {
        final byte[] chunk = new byte[CLUSTER_LENGTH_IN_BYTES];
        System.arraycopy(content, content.length - remainingContent, chunk, 0, CLUSTER_LENGTH_IN_BYTES);
        dataSectorAccessor.write(calculateOffset(currentCluster), chunk);
        currentCluster = fatManager.getNextFreeCluster(currentCluster);
        remainingContent -= CLUSTER_LENGTH_IN_BYTES;
      }
      if (remainingContent != 0) {
        final byte[] remaining = new byte[remainingContent];
        System.arraycopy(content, content.length - remainingContent, remaining, 0, CLUSTER_LENGTH_IN_BYTES);
        dataSectorAccessor.write(calculateOffset(currentCluster), remaining);
      }
    }
  }

  private long calculateOffset(final int clusterNumber) {
    return initialOffset + clusterNumber * CLUSTER_LENGTH_IN_BYTES;
  }

  @GuardedBy("guardedReaderWriter.guard.readLock")
  private List<StorageEntryHeader> readDirectoryContentFromByteArray(@Nonnull final byte[] fsContent) {
    if (fsContent.length % StorageEntryHeader.length() != 0) {
      throw new MalformedContentException();
    }
    final List<StorageEntryHeader> storageEntryHeaders = new ArrayList<>(fsContent.length / StorageEntryHeader.length());
    for (int i = 0; i < fsContent.length; i += StorageEntryHeader.length()) {
      storageEntryHeaders.add(StorageEntryHeader.fromByteArray(fsContent, i));
    }
    return storageEntryHeaders;
  }

  private static int storageHeaderDirectoryChildOffsetInBytes(final int storageEntryIndex) {
    return storageEntryIndex * StorageEntryHeader.length();
  }
}
