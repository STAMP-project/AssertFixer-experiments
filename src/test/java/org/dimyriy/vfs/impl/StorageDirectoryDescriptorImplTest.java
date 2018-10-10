package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectoryDescriptor;
import org.dimyriy.vfs.StorageFileDescriptor;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.StorageRecordDescriptor;
import org.dimyriy.vfs.impl.exceptions.StorageDirectoryNotEmptyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 09.10.18
 */
class StorageDirectoryDescriptorImplTest {
  private InfileFileSystem fileSystem = null;

  @BeforeEach
  void setUp() throws IOException {
    final Path tmp = Files.createTempDirectory("tmp");
    fileSystem = InfileFileSystemFactory.getInstance().createNewFileSystem(tmp.toAbsolutePath().toString(), "temporary.vfs", 12);
  }

  @Test
  void delete_ThrowsException_WhenDirectoryNotEmpty() {
    try (final StorageFileDescriptor file = fileSystem.createFileRecursively(fileSystem.createPath("/directory/emptyFile"))) {
      assertThat(file).isNotNull();
    }
    try (final StorageRecordDescriptor directory = new StoragePath("/directory", fileSystem).open()) {
      Assertions.assertThrows(StorageDirectoryNotEmptyException.class, directory::delete);
    }
  }

  @Test
  void delete_DoesNotThrow_WhenDirectoryIsEmpty() {
    try (final StorageFileDescriptor file = fileSystem.createFileRecursively(fileSystem.createPath("/directory/emptyFile"))) {
      assertThat(file).isNotNull();
      file.delete();
    }
    try (final StorageRecordDescriptor directory = new StoragePath("/directory", fileSystem).open()) {
      Assertions.assertDoesNotThrow(directory::delete);
    }
  }

  @Test
  void createDirectoryRecursively_DoesNotModifyAlreadyOpenedDirectoryDescriptor() {
    try (final StorageDirectoryDescriptor d = fileSystem.createDirectoryRecursively(fileSystem.createPath("/one/two"))) {
      try (final StorageDirectoryDescriptor ignored = fileSystem.createDirectoryRecursively(fileSystem.createPath("/one/two"))) {
        final StorageFileDescriptor f = d.createChildFile("three.txt");
        f.write(new byte[]{19, 17, 13});
        f.delete();
      }
    }
  }

  @AfterEach
  void tearDown() throws IOException {
    if (fileSystem != null) {
      fileSystem.close();
    }
  }
}