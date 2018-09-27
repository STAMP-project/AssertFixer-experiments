package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StorageClosingResourceFailedException;
import org.dimyriy.vfs.impl.misc.NoArgVoid;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.File;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
@NotThreadSafe
class StorageFatManager implements AutoCloseable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageFatManager.class);
  private final BoundStorageReaderWriter primaryFatAccessor;
  private final BoundStorageReaderWriter secondaryFatAccessor;
  private final long primaryFatOffset;
  private final long secondaryFatOffset;
  private final BitSet occupiedClusters;
  private final BitSet badClusters;
  private final int numberOfClusters;
  private final AtomicInteger smallestPossibleClearBit = new AtomicInteger(1);

  StorageFatManager(@Nonnull final File file, final int numberOfClusters, @Nonnull final Storage.Configuration configuration) {
    final PositiveLongRange primaryFatRange = StorageConstants.primaryFileAllocationTableRange(numberOfClusters);
    this.primaryFatAccessor = new BoundStorageReaderWriter(file, primaryFatRange);
    this.primaryFatOffset = primaryFatRange.getLowerBoundClosed();
    final PositiveLongRange secondaryFatRange = StorageConstants.secondaryFileAllocationTableRange(numberOfClusters);
    this.secondaryFatAccessor = new BoundStorageReaderWriter(file, secondaryFatRange);
    this.secondaryFatOffset = secondaryFatRange.getLowerBoundClosed();
    this.numberOfClusters = numberOfClusters;
    this.occupiedClusters = new BitSet(this.numberOfClusters);
    this.badClusters = new BitSet(this.numberOfClusters);
    if (configuration.isLoadExisting()) {
      readFatEmptyClustersFromDisk();
    }
  }

  @Override
  public void close() {
    StorageClosingResourceFailedException thrown = null;
    try {
      primaryFatAccessor.close();
    } catch (final Exception e) {
      LOGGER.warn("Closing underlying BoundStorageReaderWriter failed with exception", e);
      thrown = new StorageClosingResourceFailedException(e);
    }
    try {
      secondaryFatAccessor.close();
    } catch (final Exception e) {
      if (thrown != null) {
        thrown.addSuppressed(e);
      } else {
        thrown = new StorageClosingResourceFailedException(e);
      }
    }
    if (thrown != null) {
      throw thrown;
    }
  }

  @GuardedBy("org.dimyriy.vfs.impl.StorageDataManager.guardedReaderWriter.guard.readLock")
  int getNextCluster(final int clusterNumber) {
    return ByteUtil.toInt(primaryFatAccessor.read(calculatePrimaryFatClusterOffset(clusterNumber), Integer.BYTES));
  }

  @GuardedBy("org.dimyriy.vfs.impl.StorageDataManager.guardedReaderWriter.guard.writeLock")
  int getNextFreeCluster(final int clusterNumber) {
    final int nextFreeCluster = occupiedClusters.nextClearBit(smallestPossibleClearBit.get());
    occupiedClusters.set(nextFreeCluster);
    smallestPossibleClearBit.set(nextFreeCluster);
    LOGGER.trace("Getting next free cluster. Current cluster: {}, next cluster: {}", clusterNumber, nextFreeCluster);
    secondaryFatAccessor.write(calculateSecondaryFatClusterOffset(clusterNumber), ByteUtil.toByteArray(nextFreeCluster));
    secondaryFatAccessor.write(calculateSecondaryFatClusterOffset(nextFreeCluster), ByteUtil.toByteArray(eof()));
    return nextFreeCluster;
  }

  @GuardedBy("org.dimyriy.vfs.impl.StorageDataManager.guardedReaderWriter.guard.writeLock")
  void clearCluster(final int clusterNumber) {
    final int smallestClearCluster = smallestPossibleClearBit.get();
    LOGGER.trace("Clearing cluster {}, current smallest possible clear cluster is {}", clusterNumber, smallestClearCluster);
    occupiedClusters.clear(clusterNumber);
    if (smallestClearCluster > clusterNumber) {
      LOGGER.trace("Setting smallest possible clear cluster to {}, previously was {}", clusterNumber, smallestClearCluster);
      smallestPossibleClearBit.set(clusterNumber);
    }
  }

  void executeTransactional(@Nonnull final NoArgVoid write) {
    write.apply();
    copySecondaryClusterToPrimary();
  }

  @GuardedBy("org.dimyriy.vfs.impl.StorageDataManager.guardedReaderWriter.guard.writeLock")
  private void readFatEmptyClustersFromDisk() {
    LOGGER.trace("Reading primary FAT from disk");
    final byte[] primary = primaryFatAccessor.read(primaryFatOffset, getLength());
    LOGGER.trace("Reading secondary FAT from disk");
    final byte[] secondary = secondaryFatAccessor.read(primaryFatOffset, getLength());
    if (!Arrays.equals(primary, secondary)) {
      LOGGER.warn("Primary and secondary FATs do not match, will overwrite secondary FAT with contents of primary");
      secondaryFatAccessor.write(secondaryFatOffset, primary);
    }
    LOGGER.trace("Filling FAT bit set");
    for (int i = 0; i < primary.length; i += Integer.BYTES) {
      final int clusterValue = ByteUtil.readIntAtOffset(primary, i);
      if (FileAllocationTableConstants.isBadCluster(clusterValue)) {
        badClusters.set(i);
      } else if (!FileAllocationTableConstants.isFreeCluster(clusterValue)) {
        occupiedClusters.set(i);
      }
    }
    LOGGER.trace("Reading FAT finished. Number of empty clusters is {}", occupiedClusters.cardinality());
  }

  private int getLength() {
    return numberOfClusters * Integer.BYTES;
  }

  private int eof() {
    return FileAllocationTableConstants.EMPTY_CLUSTER;
  }

  @GuardedBy("org.dimyriy.vfs.impl.StorageDataManager.guardedReaderWriter.guard.writeLock")
  private void copySecondaryClusterToPrimary() {
    LOGGER.trace("Copying secondary FAT content to primary fat (commiting r/w transaction) started");
    primaryFatAccessor.write(primaryFatOffset, secondaryFatAccessor.read(secondaryFatOffset, numberOfClusters));
    LOGGER.trace("Copying secondary FAT content to primary fat (commiting r/w transaction) finished");
  }

  private long calculatePrimaryFatClusterOffset(final int clusterNumber) {
    return calculateClusterOffset(clusterNumber, primaryFatOffset);
  }

  private long calculateSecondaryFatClusterOffset(final int clusterNumber) {
    return calculateClusterOffset(clusterNumber, secondaryFatOffset);
  }

  private long calculateClusterOffset(final int clusterNumber, final long fatOffset) {
    return clusterNumber * Integer.BYTES + fatOffset;
  }
}
