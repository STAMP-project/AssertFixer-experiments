package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.PlatformConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.FileSystemLockedByAnotherProcessException;
import org.dimyriy.vfs.impl.exceptions.PlatformFileAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageClosingResourceFailedException;
import org.dimyriy.vfs.impl.exceptions.StorageIOException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
class Storage implements AutoCloseable {
  private static final Logger LOGGER = LoggerFactory.getLogger(Storage.class);
  private final StorageMetadataManager storageMetadataManager;
  private final StorageDataManager storageDataManager;
  private final String absoluteFullPathOfStorageFile;

  Storage(@Nonnull final File file, @Nonnull final Configuration configuration) {
    Assertions.fileExistsAndIsReadableAndIsWritable(file);
    this.absoluteFullPathOfStorageFile = file.getAbsolutePath();
    final InitializationStrategy initializer = configuration.chooseInitializationStrategy();
    this.storageMetadataManager = initializer.initializeStorageMetadata(file, configuration);
    this.storageDataManager = new StorageDataManager(file, storageMetadataManager, configuration);
  }

  @Override
  public void close() {
    StorageClosingResourceFailedException thrown = null;
    try {
      storageMetadataManager.close();
    } catch (final Exception e) {
      LOGGER.warn("Got exception while closing underlying metadata manager", e);
      thrown = new StorageClosingResourceFailedException(e);
    } finally {
      try {
        storageDataManager.close();
      } catch (final Exception e) {
        LOGGER.warn("Got exception while closing underlying storage data manager", e);
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
  }

  String getAbsoluteFullPathOfStorageFile() {
    return absoluteFullPathOfStorageFile;
  }

  interface InitializationStrategy {
    StorageMetadataManager initializeStorageMetadata(@Nonnull final File file, @Nonnull final Configuration configuration);

    class CreateNew implements InitializationStrategy {

      @Override
      public StorageMetadataManager initializeStorageMetadata(@Nonnull final File file, @Nonnull final Configuration configuration) {
        Assertions.fileDoesNotExist(file);
        try {
          final boolean fileDidNotExist = file.createNewFile();
          if (!fileDidNotExist) {
            throw new PlatformFileAlreadyExistsException();
          }
        } catch (final IOException e) {
          throw new StorageIOException(e);
        }
        final StorageMetadataManager metadataManager = new StorageMetadataManager(file, configuration.numberOfClusters, SystemUtil.currentTS());
        setFileSize(file, metadataManager.numberOfClusters());
        metadataManager.updateRootDirectoryHeader();
        return metadataManager;
      }

      private void setFileSize(@Nonnull final File file, final int numberOfClusters) {
        try (final RandomAccessFile randomAccessFile = new RandomAccessFile(file, PlatformConstants.RANDOM_ACCESS_FILE_READ_WRITE_MODE)) {
          randomAccessFile.setLength(StorageConstants.calculateResultingFileSizeInBytes(numberOfClusters));
        } catch (final IOException e) {
          LOGGER.error("Got exception while trying to set file size", e);
          throw new StorageIOException(e);
        }
      }

    }

    class LoadExisting implements InitializationStrategy {
      @Override
      public StorageMetadataManager initializeStorageMetadata(@Nonnull final File file, @Nonnull final Configuration configuration) {
        Assertions.fileExistsAndIsReadableAndIsWritable(file);
        final StorageMetadataManager metadataManager = new StorageMetadataManager(file);
        initializeInternally(metadataManager);
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

  static class Configuration {
    private static final InitializationStrategy FORCIBLY_ACQUIRE_LOCKED = new InitializationStrategy.LoadExisting();
    private static final InitializationStrategy FAIL_ON_LOCKED = new InitializationStrategy.FailOnLocked();
    private static final InitializationStrategy CREATE_NEW = new InitializationStrategy.CreateNew();
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

    Configuration forceFileUnlock(final boolean forciblyLockFile) {
      this.forciblyLockFile = forciblyLockFile;
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

    Configuration withNumberOfClusters(final int numberOfClusters) {
      this.numberOfClusters = numberOfClusters;
      return this;
    }

    boolean isForciblyLockFile() {
      return forciblyLockFile;
    }

    boolean isLoadExisting() {
      return loadExisting;
    }
  }
}
