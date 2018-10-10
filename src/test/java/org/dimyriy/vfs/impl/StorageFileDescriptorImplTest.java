package org.dimyriy.vfs.impl;

import org.assertj.core.api.Assertions;
import org.dimyriy.vfs.StorageFileDescriptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dmitrii Bogdanov
 * Created at 02.10.18
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class StorageFileDescriptorImplTest {
  private InfileFileSystem fileSystem = null;

  @BeforeEach
  void setUp() throws IOException {
    final Path tmp = Files.createTempDirectory("tmp");
    fileSystem = InfileFileSystemFactory.getInstance().createNewFileSystem(tmp.toAbsolutePath().toString(), "temporary.vfs", 12);
  }

  @Test
  void getFileSizeReturnsZeroForEmptyFile() {
    try (final StorageFileDescriptor file = fileSystem.createFileRecursively(fileSystem.createPath("/emptyFile"))) {
      Assertions.assertThat(file.size()).isEqualTo(0);
    }
  }

  @Test
  void getFileSizeReturns_CorrectSize_AfterContentWritten() {
    try (final StorageFileDescriptor file = fileSystem.createFileRecursively(fileSystem.createPath("/emptyFile"))) {
      file.write(new byte[1024]);
      Assertions.assertThat(file.size()).isEqualTo(1024);
    }
  }

  @Test
  void getFileSizeReturns_CorrectSize_AfterContentAppendedToFile() {
    try (final StorageFileDescriptor file = fileSystem.createFileRecursively(fileSystem.createPath("/emptyFile"))) {
      file.write(new byte[1024]);
      Assertions.assertThat(file.size()).isEqualTo(1024);
    }
  }

  @AfterEach
  void tearDown() throws IOException {
    if (fileSystem != null) {
      fileSystem.close();
    }
  }
}