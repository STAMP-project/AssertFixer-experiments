package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.MetadataConstants;
import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

import static org.dimyriy.vfs.impl.constants.StorageConstants.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
class StorageMetadata {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageMetadata.class);
  private final int numberOfClusters;
  private int rootDirectoryNumberOfEntries;
  private long rootDirectoryLastModifiedTimestamp;
  private int lock;

  StorageMetadata(final int numberOfClusters, final int rootDirectoryNumberOfEntries, final long rootDirectoryLastModifiedTimestamp, final int lock) {
    if (numberOfClusters > FILE_SYSTEM_MAX_NUMBER_OF_CLUSTERS) {
      LOGGER.debug("Attempted to create metadata with filesystem size {} that is greater than limit {}", numberOfClusters, FILE_SYSTEM_MAX_NUMBER_OF_CLUSTERS);
      throw new FileSystemSizeGreaterThanAllowedMaximumException();
    }
    if (numberOfClusters < FILE_SYSTEM_MIN_NUMBER_OF_CLUSTERS) {
      LOGGER.debug("Attempted to create metadata with filesystem size {} that is smaller than limit {}", numberOfClusters, FILE_SYSTEM_MIN_NUMBER_OF_CLUSTERS);
      throw new FileSystemSizeSmallerThanAllowedMinimumException();
    }
    if (rootDirectoryNumberOfEntries < 0) {
      throw new IllegalArgumentException("Number of entries cannot be negative");
    }
    if (rootDirectoryNumberOfEntries > MAX_NUMBER_OF_ENTRIES_IN_DIRECTORY) {
      throw new MaximumNumberOfEntriesInDirectoryExceededException();
    }
    this.numberOfClusters = numberOfClusters;
    this.rootDirectoryNumberOfEntries = rootDirectoryNumberOfEntries;
    this.rootDirectoryLastModifiedTimestamp = rootDirectoryLastModifiedTimestamp;
    this.lock = lock;
  }

  @Override
  public String toString() {
    return "StorageMetadata{" +
      "numberOfClusters=" + numberOfClusters +
      ", updateLockValue=" + lock +
      '}';
  }

  void setLockValue(final int lockValue) {
    this.lock = lockValue;
  }

  int getLock() {
    return lock;
  }

  void unlock() {
    this.lock = MetadataConstants.UNLOCKED_MAGIC;
  }

  boolean isLocked() {
    return lock != MetadataConstants.UNLOCKED_MAGIC && lock != calculateLockValue();
  }

  int getNumberOfClusters() {
    return numberOfClusters;
  }

  int getRootDirectoryNumberOfEntries() {
    return rootDirectoryNumberOfEntries;
  }

  void setRootDirectoryNumberOfEntries(final int rootDirectoryNumberOfEntries) {
    this.rootDirectoryNumberOfEntries = rootDirectoryNumberOfEntries;
  }

  long getRootDirectoryLastModifiedTimestamp() {
    return rootDirectoryLastModifiedTimestamp;
  }

  void setRootDirectoryLastModifiedTimestamp(final long timestamp) {
    this.rootDirectoryLastModifiedTimestamp = timestamp;
  }

  void writeMetadata(final BoundStorageReaderWriter writer) {
    LOGGER.trace("Writing metadata to writer {}", writer);
    writer.write(MetadataConstants.OFFSET, toByteArray());
    LOGGER.trace("Writing metadata to writer {} is finished {}", writer, this);
  }

  private byte[] toByteArray() {
    final byte[] result = new byte[MetadataConstants.LENGTH];
    LOGGER.trace("Writing fs marker {} to array", MetadataConstants.FS_MARKER_MAGIC);
    ByteUtil.writeIntAtOffset(result, MetadataConstants.FS_MARKER_OFFSET, MetadataConstants.FS_MARKER_MAGIC);
    LOGGER.trace("Writing updateLockValue {} to array", lock);
    ByteUtil.writeIntAtOffset(result, MetadataConstants.LOCK_OFFSET, lock);
    LOGGER.trace("Writing number of clusters {} to array", numberOfClusters);
    ByteUtil.writeIntAtOffset(result, MetadataConstants.NUMBER_OF_CLUSTERS_OFFSET, numberOfClusters);
    final int checksum = checkSum();
    LOGGER.trace("Writing checksum {} to array", checksum);
    ByteUtil.writeIntAtOffset(result, MetadataConstants.CHECKSUM_OFFSET, checksum);
    LOGGER.trace("Writing number of entries in root directory {} to array", rootDirectoryNumberOfEntries);
    ByteUtil.writeIntAtOffset(result, MetadataConstants.NUMBER_OF_ROOT_DIRECTORY_ENTRIES_OFFSET, rootDirectoryNumberOfEntries);
    LOGGER.trace("Writing modification timestamp of root directory {} to array", rootDirectoryLastModifiedTimestamp);
    ByteUtil.writeLongAtOffset(result, MetadataConstants.ROOT_DIRECTORY_MODIFICATION_TS_OFFSET, rootDirectoryLastModifiedTimestamp);
    return result;
  }

  private int checkSum() {
    int result = numberOfClusters;
    result = 31 * result + MetadataConstants.FS_MARKER_MAGIC;
    result = 31 * result + lock;
    result = 31 * result + rootDirectoryNumberOfEntries;
    result = 31 * result + (int) (rootDirectoryLastModifiedTimestamp % MetadataConstants.CHECKSUM_MAGIC_PRIME);
    return result;
  }

  private void validateCheckSum(final int checksum) {
    LOGGER.trace("Validating metadata checksum {}", checksum);
    if (this.checkSum() != checksum) {
      LOGGER.warn("Validating metadata checksum {} failed", checksum);
      throw new MalformedMetadataException();
    }
    LOGGER.trace("Validating metadata checksum {} succeeded", checksum);
  }

  static StorageMetadata readMetadata(final BoundStorageReaderWriter reader) {
    LOGGER.trace("Reading metadata using reader {}", reader);
    final StorageMetadata storageMetadata = fromByteArray(reader.read(MetadataConstants.OFFSET, MetadataConstants.LENGTH));
    LOGGER.trace("Read metadata: {}", storageMetadata);
    return storageMetadata;
  }

  private static int calculateLockValue() {
    return SystemUtil.getCurrentProcessPid();
  }

  private static StorageMetadata fromByteArray(@Nonnull final byte[] metadata) {
    validateFsMarker(readFsMarker(metadata));
    final StorageMetadata storageMetadata = new StorageMetadata(readNumberOfClusters(metadata),
                                                                readRootEntriesCount(metadata),
                                                                readRootModificationTimestamp(metadata),
                                                                readLock(metadata));
    storageMetadata.validateCheckSum(readCheckSum(metadata));
    return storageMetadata;
  }

  private static void validateFsMarker(final int fsMarker) {
    LOGGER.trace("Validating FS marker {}", fsMarker);
    if (fsMarker != MetadataConstants.FS_MARKER_MAGIC) {
      LOGGER.warn("Validating FS marker {} failed", fsMarker);
      throw new WrongStorageSystemMarkerException();
    }
    LOGGER.trace("Validating FS marker {} succeeded", fsMarker);
  }

  private static int readFsMarker(@Nonnull final byte[] source) {
    return ByteUtil.readIntAtOffset(source, MetadataConstants.FS_MARKER_OFFSET);
  }

  private static int readLock(@Nonnull final byte[] source) {
    LOGGER.trace("Reading updateLockValue started");
    final int lock = ByteUtil.readIntAtOffset(source, MetadataConstants.LOCK_OFFSET);
    LOGGER.trace("Read updateLockValue: {}", lock);
    return lock;
  }

  private static int readNumberOfClusters(@Nonnull final byte[] source) {
    LOGGER.trace("Reading number of clusters size started");
    final int numberOfClusters = ByteUtil.readIntAtOffset(source, MetadataConstants.NUMBER_OF_CLUSTERS_OFFSET);
    LOGGER.trace("Read number of clusters: {}", numberOfClusters);
    return numberOfClusters;
  }

  private static int readCheckSum(@Nonnull final byte[] source) {
    LOGGER.trace("Reading checksum started");
    final int checksum = ByteUtil.readIntAtOffset(source, MetadataConstants.CHECKSUM_OFFSET);
    LOGGER.trace("Read checksum: {}", checksum);
    return checksum;
  }

  private static int readRootEntriesCount(@Nonnull final byte[] source) {
    LOGGER.trace("Reading number of entries in root directory started");
    final int numberOfEntries = ByteUtil.readIntAtOffset(source, MetadataConstants.NUMBER_OF_ROOT_DIRECTORY_ENTRIES_OFFSET);
    LOGGER.trace("Read number of entries in root directory: {}", numberOfEntries);
    return numberOfEntries;
  }

  private static long readRootModificationTimestamp(@Nonnull final byte[] source) {
    LOGGER.trace("Reading modification timestamp of root directory started");
    final long timestamp = ByteUtil.readLongAtOffset(source, MetadataConstants.ROOT_DIRECTORY_MODIFICATION_TS_OFFSET);
    LOGGER.trace("Read modification timestamp: {}", timestamp);
    return timestamp;
  }
}
