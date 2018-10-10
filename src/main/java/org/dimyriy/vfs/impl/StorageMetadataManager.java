package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.MetadataConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
@NotThreadSafe
public class StorageMetadataManager implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageMetadataManager.class);
  private final BoundStorageReaderWriter storageMetadataAccessor;
  private final StorageMetadata metadata;
  private final StorageDirectoryEntryHeader.Root rootDirectoryHeader;

  StorageMetadataManager(@Nonnull final File file, @Nonnull final Storage.Configuration configuration) {
    this.storageMetadataAccessor = new BoundStorageReaderWriter(file, MetadataConstants.metadataByteRange(), configuration.getMetadataReadersPoolSize());
    if (configuration.isLoadExisting()) {
      LOGGER.trace("Initializing metadata manager for existing FS in file {}", file.getAbsolutePath());
      this.metadata = readMetadata();
    } else {
      LOGGER.trace("Initializing metadata manager for new FS in file {} with numberOfClusters {} and clusterSize {}", file.getAbsolutePath(),
                   configuration.getNumberOfClusters(), configuration.getClusterSizeInBytes());
      this.metadata = createMetadata(configuration);
    }
    this.rootDirectoryHeader = new StorageDirectoryEntryHeader.Root(numberOfRootDirectoryEntries(), rootDirectoryModificationTimestamp());
  }

  @Override
  public void close() throws IOException {
    LOGGER.trace("Closing metadataManager started");
    try {
      storageMetadataAccessor.close();
    } catch (final IOException e) {
      LOGGER.warn("Closing metadataManager failed", e);
      throw e;
    }
    LOGGER.trace("Closing metadataManager finished");
  }

  int numberOfRootDirectoryEntries() {
    return metadata.getRootDirectoryNumberOfEntries();
  }

  void init(@Nonnull final StorageDataManager dataManager) {
    this.rootDirectoryHeader.setDataManager(dataManager);
  }

  StorageDirectoryEntryHeader.Root getRootDirectory() {
    return rootDirectoryHeader;
  }

  StorageMetadata getMetadata() {
    return metadata;
  }

  boolean isLocked() {
    return metadata.isLocked();
  }

  int numberOfClusters() {
    return metadata.getNumberOfClusters();
  }

  int clusterSize() {
    return metadata.clusterSize();
  }

  void updateLockValue() {
    metadata.setLockValue(SystemUtil.getCurrentProcessPid());
  }

  void flush() {
    LOGGER.trace("Writing metadata {} on disk started", metadata);
    flushMetadata();
    LOGGER.trace("Writing metadata {} on disk finished", metadata);
  }

  void flushMetadata() {
    LOGGER.trace("Flushing metadata started");
    final short numberOfEntries = (short) (rootDirectoryHeader.getFileSize() / StorageEntryHeader.sizeInBytes());
    final long timestamp = SystemUtil.currentTS();
    LOGGER.trace("Updating root directory header with number of entries {} and modification timestamp {}", numberOfEntries, timestamp);
    metadata.setRootDirectoryLastModifiedTimestamp(timestamp);
    metadata.setRootDirectoryNumberOfEntries(numberOfEntries);
    metadata.writeMetadata(storageMetadataAccessor);
    LOGGER.trace("Flushing metadata {} finished", metadata);
  }

  private StorageMetadata readMetadata() {
    LOGGER.trace("Reading metadata from disk started");
    final StorageMetadata storageMetadata = StorageMetadata.readMetadata(storageMetadataAccessor);
    LOGGER.trace("Reading metadata {} from disk finished", storageMetadata);
    return storageMetadata;
  }

  private StorageMetadata createMetadata(@Nonnull final Storage.Configuration configuration) {
    return new StorageMetadata(configuration.getNumberOfClusters(),
                               configuration.getClusterSizeInBytes(),
                               StorageConstants.numberOfEntriesInEmptyDirectory(),
                               SystemUtil.currentTS(),
                               lockValue());
  }

  private long rootDirectoryModificationTimestamp() {
    return metadata.getRootDirectoryLastModifiedTimestamp();
  }

  private int lockValue() {
    return SystemUtil.getCurrentProcessPid();
  }
}
