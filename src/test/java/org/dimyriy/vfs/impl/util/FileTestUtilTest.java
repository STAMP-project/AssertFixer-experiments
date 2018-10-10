package org.dimyriy.vfs.impl.util;

import org.dimyriy.vfs.impl.exceptions.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class FileTestUtilTest {

  @Test
  void createFileInstance_ThrowsException_WhenParentDirectoryDoesNotExist() {
    Assertions.assertThrows(InitializationException.class,
                            () -> FileUtil.createFileInstanceForStorageFileSystem(Paths.get("not_exists").toAbsolutePath().toString(), "dummy"));
  }

  @Test
  void createFileInstance_ThrowsException_WhenParentDirectoryIsRegularFile() throws IOException {
    final Path regularFile = Paths.get("regularFile").toAbsolutePath();
    final File file = regularFile.toFile();
    file.createNewFile();
    Assertions.assertThrows(InitializationException.class,
                            () -> FileUtil.createFileInstanceForStorageFileSystem(regularFile.toAbsolutePath().toString(), "dummy"));
    file.delete();
  }

  @Test
  void createFileInstance_CreatesReadableWritableRegularFileInSpecifiedDirectory_WhenParentDirectoryIsDirectory() throws IOException {
    final Path parentDirectory = Paths.get(".").toAbsolutePath();
    final File file = FileUtil.createFileInstanceForStorageFileSystem(parentDirectory.toString(), "dummy");
    file.createNewFile();
    assertThat(file.isDirectory()).as("created file instance is not a directory").isFalse();
    assertThat(file.isFile()).as("created file instance is regular file").isTrue();
    assertThat(file.getParent()).as("parent of created file is correct").isEqualTo(parentDirectory.toString());
    file.delete();
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void toAbsolutePathCreatesCorrectAbsoluteFullPathOnWindowsSystem() {
    assertThat(FileUtil.toAbsolutePath("C:\\Program Files", "test.vfs")).isEqualTo("C:\\Program Files\\test.vfs");
  }

  @Test
  @DisabledOnOs(OS.WINDOWS)
  void toAbsolutePathCreatesCorrectAbsoluteFullPathForWindows() {
    assertThat(FileUtil.toAbsolutePath("/opt", "test.vfs")).isEqualTo("/opt/test.vfs");
  }
}