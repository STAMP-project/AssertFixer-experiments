package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.MalformedContentException;
import org.dimyriy.vfs.impl.misc.NoArgVoid;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.isBadCluster;
import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.isEmptyCluster;

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

  long getFreeSpace() {
    return fatManager.getNumberOfEmptyClusters() * (long) clusterSize;
  }

  void processCorruptedEntry(final int startingCluster, final int fileSize) {
    LOGGER.trace("Processing corrupted entry at cluster {} with filesize {} started", startingCluster, fileSize);
    if (!isBadCluster(startingCluster)) {
      fatManager.executeTransactional(() -> {
        final OffsetRwState rwState = new OffsetRwState(startingCluster, fileSize, 0);
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
        LOGGER.trace("Setting bad clusters {} started", corrupted);
        fatManager.setBadClusters(corrupted);
        LOGGER.trace("Setting bad clusters {} finished", corrupted);
      });
    }
    LOGGER.trace("Processing corrupted entry at cluster {} with filesize {} finished", startingCluster, fileSize);
  }

  void updateRootDirectoryHeader() {
    this.metadataManager.flushMetadata();
  }

  int occupyCluster(final int currentCluster) {
    return fatManager.getNextFreeCluster(currentCluster);
  }

  int freeCluster(final int cluster) {
    return fatManager.clearCluster(cluster);
  }

  void transactional(final NoArgVoid writer) {
    fatManager.executeTransactional(writer);
  }

  <T> T transactional(@Nonnull final Supplier<T> creator) {
    return fatManager.createTransactional(creator);
  }

  byte[] readContent(final OffsetRwState offsetReadParameter) {
    if (isEmptyCluster(offsetReadParameter.currentCluster)) {
      return new byte[0];
    }
    if (isBadCluster(offsetReadParameter.currentCluster)) {
      throw new MalformedContentException();
    }
    final ByteBuffer b = ByteBuffer.allocate(offsetReadParameter.remainingBytes);
    offsetReadParameter.skipOffsetClusters(clusterSize, fatManager::getValueOfCluster);
    while (offsetReadParameter.remainingBytes + offsetReadParameter.remainingOffset >= clusterSize) {
      readFromOneClusterWithOffsetToBuffer(offsetReadParameter, clusterSize - offsetReadParameter.remainingOffset, b);
    }
    readFromOneClusterWithOffsetToBuffer(offsetReadParameter, offsetReadParameter.remainingBytes, b);
    return b.array();
  }

  void writeContent(@Nonnull final byte[] content, @Nonnull final OffsetRwState writeParameter) {
    writeParameter.skipOffsetClusters(clusterSize, fatManager::getValueOfCluster);
    while (writeParameter.remainingBytes + writeParameter.remainingOffset >= clusterSize) {
      final byte[] chunk = new byte[clusterSize - writeParameter.remainingOffset];
      System.arraycopy(content, content.length - writeParameter.remainingBytes, chunk, 0, clusterSize - writeParameter.remainingOffset);
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

  private long calculateOffset(final int clusterNumber) {
    return initialOffset + clusterNumber * clusterSize;
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

  static class OffsetRwState {
    int remainingBytes;
    int currentCluster;
    int remainingOffset;

    OffsetRwState(final int currentCluster, final int remainingBytes, final int remainingOffset) {
      this.remainingBytes = remainingBytes;
      this.currentCluster = currentCluster;
      this.remainingOffset = remainingOffset;
    }

    void skipOffsetClusters(final int clusterSize, @Nonnull final Function<Integer, Integer> clusterSupplier) {
      while (remainingOffset >= clusterSize) {
        currentCluster = clusterSupplier.apply(currentCluster);
        remainingOffset -= clusterSize;
      }
    }
  }
}
