package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.MetadataConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StorageClosingResourceFailedException;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class StorageMetadataManager implements AutoCloseable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageMetadataManager.class);
  private final BoundStorageReaderWriter storageMetadataAccessor;
  private final StorageMetadata metadata;
  private final GuardedReaderWriter guardedReaderWriter = new GuardedReaderWriter();
  private final StorageEntryHeader.RootDirectoryHeader rootDirectoryHeader;

  StorageMetadataManager(@Nonnull final File file) {
    LOGGER.trace("Initializing new StorageMetadataManager for existing FS in file {}", file.getAbsolutePath());
    this.storageMetadataAccessor = new BoundStorageReaderWriter(file, MetadataConstants.metadataByteRange());
    this.metadata = readMetadata();
    this.rootDirectoryHeader = new StorageEntryHeader.RootDirectoryHeader(numberOfRootDirectoryEntries(), rootDirectoryModificationTimestamp());
  }

  StorageMetadataManager(@Nonnull final File file,
                         final int numberOfClusters,
                         final long modificationTimestamp) {
    LOGGER.trace("Initializing new StorageMetadataManager for new FS in file {} with numberOfClusters {}", file.getAbsolutePath(), numberOfClusters);
    this.storageMetadataAccessor = new BoundStorageReaderWriter(file, MetadataConstants.metadataByteRange());
    this.metadata = new StorageMetadata(numberOfClusters, StorageConstants.numberOfEntriesInEmptyDirectory(), modificationTimestamp, lockValue());
    this.rootDirectoryHeader = new StorageEntryHeader.RootDirectoryHeader(numberOfRootDirectoryEntries(), rootDirectoryModificationTimestamp());
  }

  @Override
  public void close() {
    try {
      storageMetadataAccessor.close();
    } catch (final Exception e) {
      LOGGER.warn("Closing StorageMetadataAccessor failed with exception", e);
      throw new StorageClosingResourceFailedException(e);
    }
  }

  StorageEntryHeader.RootDirectoryHeader getRootDirectory() {
    return guardedReaderWriter.executeReadOperation(() -> rootDirectoryHeader);
  }

  void updateRootDirectoryHeader() {
    LOGGER.trace("Updating root directory header started");
    guardedReaderWriter.executeWriteOperation(() -> {
      final int numberOfEntries = rootDirectoryHeader.getFileSize() / StorageEntryHeader.length();
      final long timestamp = SystemUtil.currentTS();
      LOGGER.trace("Updating root directory header with number of entries {} and modification timestamp {}", numberOfEntries, timestamp);
      metadata.setRootDirectoryLastModifiedTimestamp(timestamp);
      metadata.setRootDirectoryNumberOfEntries(numberOfEntries);
      metadata.writeMetadata(storageMetadataAccessor);
    });
    LOGGER.trace("Updating root directory header finished");
  }

  StorageMetadata getMetadata() {
    return metadata;
  }

  boolean isLocked() {
    return metadata.isLocked();
  }

  int numberOfRootDirectoryEntries() {
    return metadata.getRootDirectoryNumberOfEntries();
  }

  long rootDirectoryModificationTimestamp() {
    return metadata.getRootDirectoryLastModifiedTimestamp();
  }

  int numberOfClusters() {
    return metadata.getNumberOfClusters();
  }

  void updateLockValue() {
    metadata.setLockValue(SystemUtil.getCurrentProcessPid());
  }

  void flush() {
    LOGGER.trace("Writing metadata {} on disk started", metadata);
    guardedReaderWriter.executeWriteOperation(() -> metadata.writeMetadata(storageMetadataAccessor));
    LOGGER.trace("Writing metadata {} on disk finished", metadata);
  }

  private int lockValue() {
    return SystemUtil.getCurrentProcessPid();
  }

  private StorageMetadata readMetadata() {
    LOGGER.trace("Reading metadata from disk started");
    final StorageMetadata storageMetadata = guardedReaderWriter.executeReadOperation(() -> StorageMetadata.readMetadata(storageMetadataAccessor));
    LOGGER.trace("Reading metadata {} from disk finished", storageMetadata);
    return storageMetadata;
  }
}
