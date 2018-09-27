package org.dimyriy.vfs.impl.util;

import org.dimyriy.vfs.impl.exceptions.PlatformFileNotDirectoryException;
import org.dimyriy.vfs.impl.exceptions.PlatformFileNotFoundException;
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
class PlatformFileUtilTest {

  @Test
  void createFileInstance_ThrowsException_WhenParentDirectoryDoesNotExist() {
    Assertions.assertThrows(PlatformFileNotFoundException.class,
                            () -> PlatformFileUtil.createRegularFileInstance(Paths.get("not_exists").toAbsolutePath().toString(), "dummy"));
  }

  @Test
  void createFileInstance_ThrowsException_WhenParentDirectoryIsRegularFile() throws IOException {
    final Path regularFile = Paths.get("regularfile").toAbsolutePath();
    final File file = regularFile.toFile();
    file.createNewFile();
    Assertions.assertThrows(PlatformFileNotDirectoryException.class,
                            () -> PlatformFileUtil.createRegularFileInstance(regularFile.toAbsolutePath().toString(), "dummy"));
    file.delete();
  }

  @Test
  void createFileInstance_CreatesReadableWritableRegularFileInSpecifiedDirectory_WhenParentDirectoryIsDirectory() throws IOException {
    final Path parentDirectory = Paths.get(".").toAbsolutePath();
    final File file = PlatformFileUtil.createRegularFileInstance(parentDirectory.toString(), "dummy");
    file.createNewFile();
    assertThat(file.isDirectory()).as("created file instance is not a directory").isFalse();
    assertThat(file.isFile()).as("created file instance is regular file").isTrue();
    assertThat(file.getParent()).as("parent of created file is correct").isEqualTo(parentDirectory.toString());
    file.delete();
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void toAbsolutePathCreatesCorrectAbsoluteFullPathOnWindowsSystem() {
    assertThat(PlatformFileUtil.toAbsolutePath("C:\\Program Files", "test.vfs")).isEqualTo("C:\\Program Files\\test.vfs");
  }

  @Test
  @DisabledOnOs(OS.WINDOWS)
  void toAbsolutePathCreatesCorrectAbsoluteFullPathForWindoes() {
    assertThat(PlatformFileUtil.toAbsolutePath("/opt", "test.vfs")).isEqualTo("/opt/test.vfs");
  }
}