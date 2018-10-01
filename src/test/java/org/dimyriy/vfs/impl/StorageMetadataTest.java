package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.dimyriy.vfs.impl.TestUtil.readMetadataFromFile;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class StorageMetadataTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageMetadataTest.class);
  private Storage.Configuration configuration = null;
  private int numberOfClusters = 1;
  private int numberOfEntriesInRootDirectory = 0;
  private long rootDirectoryModificationTimestamp = 0L;
  private int lockValueOfWellFormedLockedTestData = 0;
  private int clusterSize = 0;

  @BeforeEach
  void setUp() {
    lockValueOfWellFormedLockedTestData = 11494;
    numberOfClusters = 1;
    numberOfEntriesInRootDirectory = 5;
    clusterSize = 32;
    configuration = new Storage.Configuration().withDataReadersPoolSize(5).withMetadataReadersPoolSize(5).withNumberOfClusters(numberOfClusters);
    rootDirectoryModificationTimestamp = SystemUtil.currentTS();
  }

  @Test
  void readMetadata_ThrowsException_WhenChecksumIsInvalid() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_checksum_metadata.vfs")).getFile());
    Assertions.assertThrows(MalformedMetadataException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenFileDoesNotExist() {
    final File storage = new File("not_exist");
    Assertions.assertThrows(InitializationException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenMarkerDoesNotMatchExpected() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_fs_marker_metadata.vfs")).getFile());
    Assertions.assertThrows(WrongStorageSystemMarkerException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenReadFileSystemSizeGreaterThanMaxFileSystemSize() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_max_fs_size_metadata.vfs")).getFile());
    Assertions.assertThrows(FileSystemSizeGreaterThanAllowedMaximumException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenReadFileSystemSizeSmallerThanMinFileSystemSize() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_min_fs_size_metadata.vfs")).getFile());
    Assertions.assertThrows(FileSystemSizeSmallerThanAllowedMinimumException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ReturnsNotLockedMetadata_WhenReadingUnlockedFile() throws IOException {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/well_formed_metadata_not_locked.vfs")).getFile());
    try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
      assertThat(smm.isLocked()).isFalse();
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.numberOfRootDirectoryEntries()).isEqualTo(numberOfEntriesInRootDirectory);
    }
  }

  @Test
  void readMetadata_ReturnsLockedMetadata_WhenReadingLockedFile() throws IOException {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/well_formed_metadata_locked.vfs")).getFile());
    try (final StorageMetadataManager smm = new StorageMetadataManager(storage, configuration.loadExisting())) {
      assertThat(smm.isLocked()).isTrue();
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.clusterSize()).isEqualTo(clusterSize);
      assertThat(smm.numberOfRootDirectoryEntries()).isEqualTo(numberOfEntriesInRootDirectory);
      assertThat(smm.getMetadata().getLock()).isEqualTo(lockValueOfWellFormedLockedTestData);
    }
  }

  @Test
  void writeMetadata_CreatesCorrectFileContent_WhenWritingUnlockedToExistingEmptyFile() throws IOException {
    final File expected = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/well_formed_metadata_not_locked.vfs")).getFile());
    final File actual = File.createTempFile("vfs", ".tmp");
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual, configuration.createNew().withClusterSizeInBytes(clusterSize))) {
      smm.getRootDirectory().setFileSize(StorageEntryHeader.directoryByteSize(numberOfEntriesInRootDirectory));
      smm.getMetadata().unlock();
      smm.flush();
      assertThat(readStorageMetadataFromFile(actual)).isEqualToIgnoringGivenFields(readStorageMetadataFromFile(expected), "rootDirectoryLastModifiedTimestamp");
      assertThat(smm.numberOfRootDirectoryEntries()).isEqualTo(numberOfEntriesInRootDirectory);
      assertThat(smm.clusterSize()).isEqualTo(clusterSize);
    }
    actual.delete();
  }

  @Test
  void readMetadata_ReadsMetadataWithSameProcessIdAndFileSize_WhenWrittenLockedBySameProcessAndDifferentStorageMetadataReaderWriter() throws IOException {
    final File actual = File.createTempFile("vfs", ".tmp");
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual, configuration.createNew().withClusterSizeInBytes(clusterSize))) {
      smm.getRootDirectory().setFileSize(StorageEntryHeader.directoryByteSize(numberOfEntriesInRootDirectory));
      smm.flush();
    }
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual, configuration.loadExisting())) {
      assertThat(smm.rootDirectoryModificationTimestamp()).isNotEqualTo(rootDirectoryModificationTimestamp);
      assertThat(smm.getMetadata().getLock()).isEqualTo(SystemUtil.getCurrentProcessPid());
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.numberOfRootDirectoryEntries()).isEqualTo(numberOfEntriesInRootDirectory);
      assertThat(smm.clusterSize()).isEqualTo(clusterSize);
    }
    actual.delete();
  }

  private StorageMetadata readStorageMetadataFromFile(@Nonnull final File actual) throws IOException {
    return StorageMetadata.fromByteArray(readMetadataFromFile(actual));
  }
}