package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.NotEnoughSpaceLeftException;
import org.dimyriy.vfs.impl.misc.NoArgVoid;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.function.Supplier;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.emptyCluster;
import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.isEmptyCluster;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
@NotThreadSafe
class StorageFatManager implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageFatManager.class);
  private final BoundStorageReaderWriter mainFatAccessor;
  private final BoundStorageReaderWriter workingFatAccessor;
  private final long mainTableOffset;
  private final long workingTableOffset;
  private final BitSet occupiedClusters;
  private final BitSet badClusters;
  private final int numberOfClusters;

  StorageFatManager(@Nonnull final File file, @Nonnull final Storage.Configuration configuration) {
    this.numberOfClusters = configuration.getNumberOfClusters();
    final PositiveLongRange primaryFatRange = StorageConstants.firstFileAllocationTableRange(this.numberOfClusters);
    this.mainFatAccessor = new BoundStorageReaderWriter(file, primaryFatRange, configuration.getDataReadersPoolSize());
    this.mainTableOffset = primaryFatRange.getLowerBoundClosed();
    final PositiveLongRange secondaryFatRange = StorageConstants.secondFileAllocationTableRange(this.numberOfClusters);
    this.workingFatAccessor = new BoundStorageReaderWriter(file, secondaryFatRange, configuration.getDataReadersPoolSize());
    this.workingTableOffset = secondaryFatRange.getLowerBoundClosed();
    this.occupiedClusters = new BitSet(this.numberOfClusters);
    this.badClusters = new BitSet(this.numberOfClusters);
    if (configuration.isLoadExisting()) {
      readFatEmptyClustersFromDisk();
    } else {
      setRootDirectoryClusterValue();
    }
  }

  @Override
  public void close() throws IOException {
    LOGGER.trace("Closing fatManager started");
    final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
    LOGGER.trace("Closing mainFatAccessor");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, mainFatAccessor);
    LOGGER.trace("Closing workingFatAccessor");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, workingFatAccessor);
    if (thrown.getValue() != null) {
      LOGGER.warn("Closing fatManager failed", thrown.getValue());
      throw thrown.getValue();
    }
    LOGGER.trace("Closing fatManager finished");
  }

  int getNumberOfEmptyClusters() {
    return numberOfClusters - occupiedClusters.cardinality();
  }

  int getValueOfCluster(final int clusterNumber) {
    if (this.occupiedClusters.get(clusterNumber)) {
      return readClusterNumberFromWorkingFat(clusterNumber);
    } else if (badClusters.get(clusterNumber)) {
      return FileAllocationTableConstants.badCluster();
    } else {
      return emptyCluster();
    }
  }

  int getNextFreeCluster(final int clusterNumber) {
    ensureSize();
    final int nextFreeCluster = occupiedClusters.nextClearBit(0);
    occupiedClusters.set(nextFreeCluster);
    LOGGER.trace("Getting next free cluster. Current cluster: {}, next cluster: {}", clusterNumber, nextFreeCluster);
    if (!isEmptyCluster(clusterNumber)) {
      writeNextClusterValueToCluster(clusterNumber, nextFreeCluster);
    }
    writeNextClusterValueToCluster(nextFreeCluster, emptyCluster());
    return nextFreeCluster;
  }

  int clearCluster(final int clusterNumber) {
    final int nextCluster = getValueOfCluster(clusterNumber);
    LOGGER.trace("Clearing cluster {}", clusterNumber);
    occupiedClusters.clear(clusterNumber);
    badClusters.clear(clusterNumber);
    writeNextClusterValueToCluster(clusterNumber, eof());
    return nextCluster;
  }

  void setBadClusters(@Nonnull final int[] clusterNumbers) {
    for (int i = 0; i < clusterNumbers.length; i++) {
      badClusters.set(i);
      writeNextClusterValueToCluster(clusterNumbers[i], FileAllocationTableConstants.BAD_CLUSTER);
    }
  }

  void clearBadClusters() {
    int currentSetBit = 0;
    while (!badClusters.isEmpty()) {
      currentSetBit = badClusters.nextSetBit(currentSetBit);
      clearCluster(currentSetBit);
      badClusters.clear(currentSetBit);
    }
  }

  void executeTransactional(@Nonnull final NoArgVoid write) {
    createTransactional(() -> {
      write.apply();
      return null;
    });
  }

  <T> T createTransactional(@Nonnull final Supplier<T> write) {
    try {
      LOGGER.trace("Executing transactional operation started");
      final T result = write.get();
      LOGGER.trace("Executing transactional operation finished");
      commit();
      return result;
    } catch (final Exception e) {
      LOGGER.warn("Executing transactional operation failed", e);
      rollback();
      throw e;
    }
  }

  private void setRootDirectoryClusterValue() {
    executeTransactional(() -> {
      workingFatAccessor.write(calculateWorkingFatClusterOffset(0), ByteUtil.toByteArray(eof()));
      this.occupiedClusters.set(0);
    });
  }

  private void commit() {
    LOGGER.info("Committing transaction started");
    copyWorkingFatToMainFat();
    LOGGER.info("Committing transaction finished");
  }

  private void rollback() {
    LOGGER.info("Rollback transaction started");
    copyMainFatToWorkingFat();
    LOGGER.info("Rollback transaction finished");
  }

  private void writeNextClusterValueToCluster(final int clusterNumber, final int nextFreeCluster) {
    workingFatAccessor.write(calculateWorkingFatClusterOffset(clusterNumber), ByteUtil.toByteArray(nextFreeCluster));
  }

  private int readClusterNumberFromWorkingFat(final int clusterNumber) {
    return ByteUtil.toInt(workingFatAccessor.read(calculateWorkingFatClusterOffset(clusterNumber), Integer.BYTES));
  }

  private void readFatEmptyClustersFromDisk() {
    occupiedClusters.clear();
    badClusters.clear();
    LOGGER.trace("Reading main FAT from disk");
    final byte[] main = mainFatAccessor.read(mainTableOffset, getLength());
    LOGGER.trace("Reading working FAT from disk");
    final byte[] working = workingFatAccessor.read(workingTableOffset, getLength());
    if (!Arrays.equals(main, working)) {
      LOGGER.warn("Primary and working FATs do not match, will overwrite working FAT with contents of main FAT");
      workingFatAccessor.write(workingTableOffset, main);
    }
    LOGGER.trace("Filling FAT bit set");
    for (int i = 0; i < numberOfClusters; i++) {
      final int clusterValue = ByteUtil.readIntAtOffset(main, i * Integer.BYTES);
      if (FileAllocationTableConstants.isBadCluster(clusterValue)) {
        badClusters.set(i);
      } else if (!FileAllocationTableConstants.isFreeCluster(clusterValue)) {
        occupiedClusters.set(i);
      }
    }
    LOGGER.trace("Reading FAT finished. Number of empty clusters is {}; Number of occupied clusters is {}",
                 numberOfClusters - occupiedClusters.cardinality(), occupiedClusters.cardinality());
  }

  private int getLength() {
    return numberOfClusters * Integer.BYTES;
  }

  private int eof() {
    return FileAllocationTableConstants.EMPTY_CLUSTER;
  }

  private void copyWorkingFatToMainFat() {
    LOGGER.trace("Copying working FAT content to main fat started");
    mainFatAccessor.write(mainTableOffset, workingFatAccessor.read(workingTableOffset, getLength()));
    LOGGER.trace("Copying working FAT content to main fat finished");
  }

  private void copyMainFatToWorkingFat() {
    LOGGER.trace("Rereading main FAT content started");
    readFatEmptyClustersFromDisk();
    LOGGER.trace("Rereading main FAT content finished");
  }

  private void ensureSize() {
    LOGGER.trace("Checking whether there's any free clusters left");
    if (badClusters.cardinality() + occupiedClusters.cardinality() >= numberOfClusters) {
      throw new NotEnoughSpaceLeftException();
    }
    LOGGER.trace("Checking whether there's any free clusters left finished");
  }

  private long calculateWorkingFatClusterOffset(final int clusterNumber) {
    return calculateClusterOffset(clusterNumber, workingTableOffset);
  }

  private long calculateClusterOffset(final int clusterNumber, final long fatOffset) {
    return clusterNumber * Integer.BYTES + fatOffset;
  }
}
