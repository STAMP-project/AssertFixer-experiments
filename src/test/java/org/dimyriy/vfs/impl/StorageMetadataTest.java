package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class StorageMetadataTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageMetadataTest.class);
  private int numberOfClusters = 0;
  private int numberOfEntriesInRootDirectory = 0;
  private long rootDirectoryModificationTimestamp = 0L;
  private long modificationTimestampOfWellFormedUnlockedTestData = 0L;
  private long modificationTimestampOfWellFormedLockedTestData = 0L;

  @BeforeEach
  void setUp() {
    modificationTimestampOfWellFormedUnlockedTestData = 1538040256006L;
    modificationTimestampOfWellFormedLockedTestData = 1538040291707L;
    numberOfClusters = 1;
    numberOfEntriesInRootDirectory = 0;
    rootDirectoryModificationTimestamp = SystemUtil.currentTS();
  }

  @Test
  void readMetadata_ThrowsException_WhenChecksumIsInvalid() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_checksum_metadata.vfs")).getFile());
    Assertions.assertThrows(MalformedMetadataException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenFileDoesNotExist() {
    final File storage = new File("not_exist");
    Assertions.assertThrows(PlatformFileNotFoundException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenMarkerDoesNotMatchExpected() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_fs_marker_metadata.vfs")).getFile());
    Assertions.assertThrows(WrongStorageSystemMarkerException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenReadFileSystemSizeGreaterThanMaxFileSystemSize() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_max_fs_size_metadata.vfs")).getFile());
    Assertions.assertThrows(FileSystemSizeGreaterThanAllowedMaximumException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ThrowsException_WhenReadFileSystemSizeSmallerThanMinFileSystemSize() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/malformed_min_fs_size_metadata.vfs")).getFile());
    Assertions.assertThrows(FileSystemSizeSmallerThanAllowedMinimumException.class, () -> {
      try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
        LOGGER.trace("StorageMetadataManager: {}", smm);
      }
    });
  }

  @Test
  void readMetadata_ReturnsNotLockedMetadata_WhenReadingUnlockedFile() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/well_formed_metadata_not_locked.vfs")).getFile());
    try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
      assertThat(smm.isLocked()).isFalse();
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.numberOfRootDirectoryEntries()).isEqualTo(numberOfEntriesInRootDirectory);
      assertThat(smm.rootDirectoryModificationTimestamp()).isEqualTo(modificationTimestampOfWellFormedUnlockedTestData);
    }
  }

  @Test
  void readMetadata_ReturnsLockedMetadata_WhenReadingLockedFile() {
    final File storage = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/well_formed_metadata_locked.vfs")).getFile());
    try (final StorageMetadataManager smm = new StorageMetadataManager(storage)) {
      assertThat(smm.isLocked()).isTrue();
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.numberOfRootDirectoryEntries()).isEqualTo(numberOfEntriesInRootDirectory);
      assertThat(smm.rootDirectoryModificationTimestamp()).isEqualTo(modificationTimestampOfWellFormedLockedTestData);
    }
  }

  @Test
  void writeMetadata_CreatesCorrectFileContent_WhenWritingUnlockedToExistingEmptyFile() throws IOException {
    final File expected = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("metadata/well_formed_metadata_not_locked.vfs")).getFile());
    final File actual = File.createTempFile("vfs", ".tmp");
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual, numberOfClusters, modificationTimestampOfWellFormedUnlockedTestData)) {
      smm.getMetadata().setRootDirectoryLastModifiedTimestamp(modificationTimestampOfWellFormedUnlockedTestData);
      smm.getMetadata().unlock();
      smm.flush();
      assertThat(Util.readMetadataFromFile(actual)).isEqualTo(Util.readMetadataFromFile(expected));
    }
    actual.delete();
  }

  @Test
  void readMetadata_ReadsMetadataWithSameProcessIdAndFileSize_WhenWrittenLockedBySameProcessAndDifferentStorageMetadataReaderWriter() throws IOException {
    final File actual = File.createTempFile("vfs", ".tmp");
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual, numberOfClusters, rootDirectoryModificationTimestamp)) {
      smm.flush();
    }
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual)) {
      assertThat(smm.getMetadata().getLock()).isEqualTo(SystemUtil.getCurrentProcessPid());
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.rootDirectoryModificationTimestamp()).isEqualTo(rootDirectoryModificationTimestamp);
    }
    actual.delete();
  }

  @Test
  void readMetadata_ReturnsSameLockedMetadata_WhenWrittenLockedBySameProcessAndSameStorageMetadataReaderWriter() throws IOException {
    final File actual = File.createTempFile("vfs", ".tmp");
    try (final StorageMetadataManager smm = new StorageMetadataManager(actual, numberOfClusters, rootDirectoryModificationTimestamp)) {
      smm.flush();
      assertThat(smm.getMetadata().getLock()).isEqualTo(SystemUtil.getCurrentProcessPid());
      assertThat(smm.numberOfClusters()).isEqualTo(numberOfClusters);
      assertThat(smm.rootDirectoryModificationTimestamp()).isEqualTo(rootDirectoryModificationTimestamp);
    }
    actual.delete();
  }
}