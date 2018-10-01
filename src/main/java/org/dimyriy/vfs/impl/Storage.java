package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.PlatformConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.FileSystemLockedByAnotherProcessException;
import org.dimyriy.vfs.impl.exceptions.InitializationException;
import org.dimyriy.vfs.impl.exceptions.StorageIOException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
class Storage implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(Storage.class);
  private final StorageMetadataManager storageMetadataManager;
  private final StorageDataManager storageDataManager;
  private final String absoluteFullPathOfStorageFile;

  Storage(@Nonnull final File file, @Nonnull final Configuration configuration) {
    this.absoluteFullPathOfStorageFile = file.getAbsolutePath();
    final InitializationStrategy initializer = configuration.chooseInitializationStrategy();
    this.storageMetadataManager = initializer.initializeStorageMetadata(file, configuration);
    this.storageDataManager = new StorageDataManager(file, storageMetadataManager, configuration);
  }

  @Override
  public void close() throws IOException {
    LOGGER.trace("Closing storage started");
    final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
    LOGGER.trace("Closing storageDataManager");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, storageDataManager);
    LOGGER.trace("Closing storageMetadataManager");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, storageMetadataManager);
    if (thrown.getValue() != null) {
      LOGGER.warn("Closing storage failed", thrown.getValue());
      throw thrown.getValue();
    }
    LOGGER.trace("Closing storage finished");
  }

  StorageEntryHeader.RootDirectoryHeader getRoot() {
    return storageMetadataManager.getRootDirectory();
  }

  StorageDataManager getStorageDataManager() {
    return storageDataManager;
  }

  String getAbsoluteFullPathOfStorageFile() {
    return absoluteFullPathOfStorageFile;
  }

  interface InitializationStrategy {
    StorageMetadataManager initializeStorageMetadata(@Nonnull final File file, @Nonnull final Configuration configuration);

    default long calculateResultingFileSizeInBytes(@Nonnull final Configuration configuration) {
      return configuration.getNumberOfClusters() * (long) configuration.getClusterSizeInBytes();
    }

    default void setFileSize(@Nonnull final File file, @Nonnull final Configuration configuration) {
      try (final RandomAccessFile randomAccessFile = new RandomAccessFile(file, PlatformConstants.RANDOM_ACCESS_FILE_READ_WRITE_MODE)) {
        randomAccessFile.setLength(calculateResultingFileSizeInBytes(configuration));
      } catch (final IOException e) {
        LOGGER.error("Got exception while trying to set file size", e);
        throw new StorageIOException(e);
      }
    }

    class CreateNew implements InitializationStrategy {

      @Override
      public StorageMetadataManager initializeStorageMetadata(@Nonnull final File file, @Nonnull final Configuration configuration) {
        Assertions.fileDoesNotExist(file);
        try {
          final boolean fileDidNotExist = file.createNewFile();
          if (!fileDidNotExist) {
            throw new InitializationException("file already exists");
          }
        } catch (final IOException e) {
          throw new StorageIOException(e);
        }
        final StorageMetadataManager metadataManager = new StorageMetadataManager(file, configuration);
        setFileSize(file, configuration);
        metadataManager.flushMetadata();
        setFileSize(file, configuration);
        return metadataManager;
      }
    }

    class LoadExisting implements InitializationStrategy {
      @Override
      public StorageMetadataManager initializeStorageMetadata(@Nonnull final File file, @Nonnull final Configuration configuration) {
        Assertions.fileExistsAndIsReadableAndIsWritable(file);
        final StorageMetadataManager metadataManager = new StorageMetadataManager(file, configuration);
        initializeInternally(metadataManager);
        configuration.withNumberOfClusters(metadataManager.getMetadata().getNumberOfClusters());
        metadataManager.updateLockValue();
        metadataManager.flush();
        return metadataManager;
      }

      void initializeInternally(@Nonnull final StorageMetadataManager metadataManager) {
        LOGGER.trace("Skip checking of updateLockValue due to configuration. MetadataManager: {}", metadataManager);
      }
    }

    class FailOnLocked extends LoadExisting {
      @Override
      void initializeInternally(@Nonnull final StorageMetadataManager metadataManager) {
        LOGGER.trace("Checking if file system is locked by another process");
        if (metadataManager.isLocked()) {
          LOGGER.debug("File system is already locked");
          throw new FileSystemLockedByAnotherProcessException(metadataManager.getMetadata().getLock());
        }
        LOGGER.trace("File system is not locked");
      }
    }
  }

  @SuppressWarnings("SameParameterValue")
  static class Configuration {
    private static final InitializationStrategy FORCIBLY_ACQUIRE_LOCKED = new InitializationStrategy.LoadExisting();
    private static final InitializationStrategy FAIL_ON_LOCKED = new InitializationStrategy.FailOnLocked();
    private static final InitializationStrategy CREATE_NEW = new InitializationStrategy.CreateNew();
    private int badClustersRepairTaskPeriodInSeconds = StorageConstants.getDefaultRepairBadClustersPeriodInSeconds();
    private int pathsCacheSize = StorageConstants.getDefaultPathsCacheSize();
    private int dataReadersPoolSize = StorageConstants.getDefaultDataReadersPoolSize();
    private int metadataReadersPoolSize = StorageConstants.getDefaultMetadataReadersPoolSize();
    private int clusterSizeInBytes = StorageConstants.getDefaultClusterSizeInBytes();
    private boolean loadExisting = false;
    private boolean forciblyLockFile = false;
    private int numberOfClusters = -1;

    InitializationStrategy chooseInitializationStrategy() {
      if (isLoadExisting()) {
        if (isForciblyLockFile()) {
          return FORCIBLY_ACQUIRE_LOCKED;
        } else {
          return FAIL_ON_LOCKED;
        }
      } else {
        return CREATE_NEW;
      }
    }

    Configuration withForceUnlock(final boolean forciblyUnlock) {
      this.forciblyLockFile = forciblyUnlock;
      return this;
    }

    Configuration loadExisting() {
      this.loadExisting = true;
      return this;
    }

    Configuration createNew() {
      this.loadExisting = false;
      return this;
    }

    Configuration withDataReadersPoolSize(final int poolSize) {
      this.dataReadersPoolSize = poolSize;
      return this;
    }

    Configuration withMetadataReadersPoolSize(final int poolSize) {
      this.metadataReadersPoolSize = poolSize;
      return this;
    }

    Configuration withNumberOfClusters(final int numberOfClusters) {
      this.numberOfClusters = numberOfClusters;
      return this;
    }

    Configuration withPathsCacheSize(final int pathsCacheSize) {
      this.pathsCacheSize = pathsCacheSize;
      return this;
    }

    Configuration withBadClustersRepairTaskPeriod(final int periodInSeconds) {
      this.badClustersRepairTaskPeriodInSeconds = periodInSeconds;
      return this;
    }

    Configuration withClusterSizeInBytes(final int clusterSizeInBytes) {
      this.clusterSizeInBytes = clusterSizeInBytes;
      return this;
    }

    int getNumberOfClusters() {
      return numberOfClusters;
    }

    boolean isForciblyLockFile() {
      return forciblyLockFile;
    }

    boolean isLoadExisting() {
      return loadExisting;
    }

    int getDataReadersPoolSize() {
      return dataReadersPoolSize;
    }

    int getMetadataReadersPoolSize() {
      return metadataReadersPoolSize;
    }

    int getPathsCacheSize() {
      return pathsCacheSize;
    }

    int getBadClustersRepairTaskPeriodInSeconds() {
      return badClustersRepairTaskPeriodInSeconds;
    }

    int getClusterSizeInBytes() {
      return clusterSizeInBytes;
    }
  }
}
