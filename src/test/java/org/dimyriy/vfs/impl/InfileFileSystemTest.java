package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectoryDescriptor;
import org.dimyriy.vfs.StorageFileDescriptor;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.StorageRecordDescriptor;
import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Dmitrii Bogdanov
 * Created at 27.09.18
 */
class InfileFileSystemTest {
  private static final byte[] CONTENT_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  private static final String PATH_1 = "/file1";
  private static final String NEW_NAME_1 = "newName1";
  private static final String PATH_2 = "/directory1/file2";
  private static final String DIRECTORY_1 = "/directory1";
  private static final String PATH_2_NEW_NAME = DIRECTORY_1 + "/" + NEW_NAME_1;
  private static final String DIRECTORY_2 = "/directory1/directory2";
  private byte[] file2Content = null;
  private Path temporaryFolder = null;
  private InfileFileSystemFactory infileFileSystemFactory = null;
  private String createdFileSystemAbsolutePath = null;

  @BeforeEach
  void setUp() throws IOException {
    infileFileSystemFactory = InfileFileSystemFactory.getInstance();
    temporaryFolder = Files.createTempDirectory("tmp");
    file2Content = TestUtil.createRandomByteArray(12000);
  }

  @Test
  void open_ThrowsException_WhenDescriptorAlreadyOpen() throws IOException {
    createEmptyFileSystem(temporaryFolder, 12);
    try (final InfileFileSystem existingFs = infileFileSystemFactory.loadFileSystemFromCache(Paths.get(createdFileSystemAbsolutePath)
                                                                                                  .getParent()
                                                                                                  .toAbsolutePath()
                                                                                                  .toString(),
                                                                                             Paths.get(createdFileSystemAbsolutePath)
                                                                                                  .getFileName()
                                                                                                  .toString())) {
      assertThat(existingFs).isNotNull();
      createLargeFileInDirectory1(existingFs);
      assertThat(existingFs.createPath(PATH_2).open()).isNotNull();
      assertThrows(DescriptorAlreadyOpenException.class, () -> existingFs.createPath(PATH_2).open());
    }
  }

  @Test
  void loadFileSystemFromCache_CorrectlyReads_CreatedFiles() throws IOException {
    final InfileFileSystem createdFs = createEmptyFileSystem(temporaryFolder, 12);
    try (final InfileFileSystem loadedFs = infileFileSystemFactory.loadFileSystemFromCache(Paths.get(createdFileSystemAbsolutePath)
                                                                                                .getParent()
                                                                                                .toAbsolutePath()
                                                                                                .toString(),
                                                                                           Paths.get(createdFileSystemAbsolutePath)
                                                                                                .getFileName()
                                                                                                .toString())) {
      assertThat(loadedFs).isSameAs(createdFs);
    }
  }

  @Test
  void createFileSystem_ThrowsException_WhenFsAlreadyExistInCache() {
    createEmptyFileSystem(temporaryFolder, 12);
    assertThrows(InitializationException.class, () -> infileFileSystemFactory.createNewFileSystem(Paths.get(createdFileSystemAbsolutePath)
                                                                                                       .getParent()
                                                                                                       .toAbsolutePath()
                                                                                                       .toString(),
                                                                                                  Paths.get(createdFileSystemAbsolutePath)
                                                                                                       .getFileName()
                                                                                                       .toString(), 12));

  }

  @Test
  void createFileSystem_ThrowsException_WhenProvidedFileAlreadyExists() throws IOException {
    try (final InfileFileSystem emptyFileSystem = createEmptyFileSystem(temporaryFolder, 12)) {
      assertThat(emptyFileSystem).isNotNull();
    }
    assertThrows(InitializationException.class, () -> infileFileSystemFactory.createNewFileSystem(Paths.get(createdFileSystemAbsolutePath)
                                                                                                       .getParent()
                                                                                                       .toAbsolutePath()
                                                                                                       .toString(),
                                                                                                  Paths.get(createdFileSystemAbsolutePath)
                                                                                                       .getFileName()
                                                                                                       .toString(), 12));

  }

  @Test
  void createChild_ThrowsException_WhenEntriesNumberLargerThanMaxNumberOfDirectoryEntries() throws IOException {
    try (final InfileFileSystem fs = createEmptyFileSystem(temporaryFolder, 256)) {
      assertThat(fs).isNotNull();
      for (int i = 0; i < StorageConstants.maxNumberOfDirectoryEntries() - 1; i++) {
        try (final StorageRecordDescriptor open = fs.root().open()) {
          fs.createFile(fs.createPath("/" + i));
        }
      }
      assertThrows(DirectoryAlreadyContainsMaximumNumberOfFilesException.class,
                   () -> fs.createFile(fs.createPath("/" + StorageConstants.maxNumberOfDirectoryEntries())));
    }
  }

  @Test
  void createFile_ThrowsException_WhenFileSizeLargerThanRemainingSpace() throws IOException {
    try (final InfileFileSystem fs = createEmptyFileSystem(temporaryFolder, 4)) {
      assertThat(fs).isNotNull();
      assertThrows(NotEnoughSpaceLeftException.class, () -> createLargeFileInDirectory1(fs));
    }
  }


  @Test
  void loadFileSystemFromFile_ThrowsException_WhenFsAlreadyExistInCache() {
    createEmptyFileSystem(temporaryFolder, 12);
    assertThrows(InitializationException.class, () -> infileFileSystemFactory.loadFileSystemFromFile(Paths.get(createdFileSystemAbsolutePath)
                                                                                                          .getParent()
                                                                                                          .toAbsolutePath()
                                                                                                          .toString(),
                                                                                                     Paths.get(createdFileSystemAbsolutePath)
                                                                                                          .getFileName()
                                                                                                          .toString(),
                                                                                                     false));
  }

  @Test
  void loadFileSystemFromFile_CorrectlyReads_CreatedFiles() throws IOException {
    try (final InfileFileSystem fs = createEmptyFileSystem(temporaryFolder, 12)) {
      createLargeFileInDirectory1(fs);
    }
    try (final InfileFileSystem existingFs = infileFileSystemFactory.loadFileSystemFromFile(Paths.get(createdFileSystemAbsolutePath)
                                                                                                 .getParent()
                                                                                                 .toAbsolutePath()
                                                                                                 .toString(),
                                                                                            Paths.get(createdFileSystemAbsolutePath).getFileName().toString(),
                                                                                            false)
    ) {
      try (final StorageRecordDescriptor descriptor = existingFs.createPath(PATH_2).open()) {
        assertThat(descriptor).isNotNull();
        final byte[] bytes = ((StorageFileDescriptor) descriptor).readContent();
        assertThat(bytes).isEqualTo(file2Content);
      }
    }
  }

  @Test
  void createNewFileSystem_CreatesEmptyFileSystem() throws IOException {
    try (final InfileFileSystem fs = createEmptyFileSystem(temporaryFolder, 12)) {
      assertThat(fs.getAbsoluteFullPathOfStorageFile()).isEqualTo(temporaryFolder.toAbsolutePath() +
                                                                    temporaryFolder.getFileSystem().getSeparator() +
                                                                    "temporary.vfs");
      try (final StorageRecordDescriptor root = fs.root().open()) {
        assertThat(root).isInstanceOf(StorageDirectoryDescriptorImpl.class);
        assertThat(((StorageDirectoryDescriptorImpl) root).listChildren().isEmpty()).isTrue();
      }
    }
  }

  @Test
  void readCreatedFile_ReturnsCorrectFilByteContent() throws IOException {
    final Path tmp = Files.createTempDirectory("tmp");
    try (final InfileFileSystem fs = createEmptyFileSystem(tmp, 12)) {
      createAndDeleteFile1(fs);
      assertThrows(StorageRecordDoesNotExistException.class, () -> {
        try (final StorageRecordDescriptor descriptor = fs.createPath(PATH_1).open()) {
          assertThat(descriptor).isNotNull();
        }
      });
      createLargeFileInDirectory1(fs);
      assertThat(fs.createPath(PATH_2)).isNotNull();
      assertThat(((StorageFileDescriptor) fs.createPath(PATH_2).open()).readContent()).isEqualTo(file2Content);
    }
  }

  private void createAndDeleteFile1(final InfileFileSystem fs) {
    try (final StorageFileDescriptor file = fs.createFile(fs.createPath(PATH_1))) {
      assertThat(file).isNotNull();
      assertThat(file.getPath()).isEqualTo(fs.createPath(PATH_1));
      file.writeContent(CONTENT_1);
      try (final StorageRecordDescriptor descriptor = fs.createPath(PATH_1).open()) {
        assertThat(descriptor).isNotNull();
        final byte[] bytes = ((StorageFileDescriptor) descriptor).readContent();
        assertThat(bytes).isEqualTo(CONTENT_1);
        try (final StorageRecordDescriptor open = fs.root().open()) {
          assertThat(open).isInstanceOf(StorageDirectoryDescriptorImpl.class);
          final List<StoragePath> actual = ((StorageDirectoryDescriptorImpl) open).listChildren();
          assertThat(actual).isEqualTo(Collections.singletonList(new StoragePath(PATH_1, fs)));
        }
        descriptor.delete();
      }
    }
  }

  private void createLargeFileInDirectory1(@Nonnull final InfileFileSystem fs) {
    createDirectory1(fs);
    try (final StorageFileDescriptor file = fs.createFile(fs.createPath(PATH_2))) {
      assertThat(file).isNotNull();
      assertThat(file.getPath()).isEqualTo(fs.createPath(PATH_2));
      file.writeContent(file2Content);
    }
    try (final StorageRecordDescriptor descriptor = fs.createPath(PATH_2).open()) {
      assertThat(descriptor).isNotNull();
      final byte[] bytes = ((StorageFileDescriptor) descriptor).readContent();
      assertThat(bytes).isEqualTo(file2Content);
    }
  }

  private void createDirectory1(@Nonnull final InfileFileSystem fs) {
    try (final StorageDirectoryDescriptor directory = fs.createDirectory(fs.createPath(DIRECTORY_1))) {
      assertThat(directory).isNotNull();
    }
  }

  private void createDirectory2(@Nonnull final InfileFileSystem fs) {
    try (final StorageDirectoryDescriptor directory = fs.createDirectory(fs.createPath(DIRECTORY_2))) {
      assertThat(directory).isNotNull();
    }
  }

  private InfileFileSystem createEmptyFileSystem(@Nonnull final Path path, final int numberOfClusters) {
    final InfileFileSystem fs = infileFileSystemFactory.createNewFileSystem(path.toAbsolutePath().toString(), "temporary.vfs", numberOfClusters);
    createdFileSystemAbsolutePath = fs.getAbsoluteFullPathOfStorageFile();
    return fs;
  }
}