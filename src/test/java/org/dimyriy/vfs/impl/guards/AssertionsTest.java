package org.dimyriy.vfs.impl.guards;

import org.dimyriy.vfs.impl.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.dimyriy.vfs.impl.guards.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
class AssertionsTest {
  private File existingFile;

  @BeforeEach
  void setUp() throws IOException {
    existingFile = createNewFileInCurrentDirectory();
  }

  @AfterEach
  void tearDown() {
    existingFile.delete();
  }

  @Test
  void isDirectory_DoesNotThrowExceptions_WhenPointingToExistingDirectory() {
    Assertions.assertDoesNotThrow(() -> isDirectoryAndExists(getCurrentDirectory()));
  }

  @Test
  void isDirectory_ThrowsException_WhenPointingToRegularFile() {
    Assertions.assertThrows(PlatformFileNotDirectoryException.class, () -> isDirectoryAndExists(existingFile));
  }

  @Test
  void isRegularFile_ThrowsException_WhenPointingToDirectory() {
    Assertions.assertThrows(PlatformFileNotRegularFileException.class, () -> isRegularFile(getCurrentDirectory()));
  }

  @Test
  void isRegularFile_DoesNotThrowExceptions_WhenPointingToRegularFile() {
    Assertions.assertDoesNotThrow(() -> isRegularFile(existingFile));
  }

  @Test
  void fileDoesNotExist_ThrowsException_WhenFileExists() {
    Assertions.assertThrows(PlatformFileAlreadyExistsException.class, () -> fileDoesNotExist(existingFile));
  }

  @Test
  void fileDoesNotExist_DoesNotThrowExceptions_WhenFileDoesNotExists() {
    Assertions.assertDoesNotThrow(() -> fileDoesNotExist(Paths.get("not_exists").toFile()));
  }

  @Test
  void fileExists_ThrowsException_WhenFileDoesNotExist() {
    Assertions.assertDoesNotThrow(() -> fileExists(existingFile));
  }

  @Test
  void fileExistsAndReadableAndWritable_DoesNotThrowExceptions_WhenFileExistsAndReadableAndWritable() {
    setReadable();
    setWritable();
    Assertions.assertDoesNotThrow(() -> fileExistsAndIsReadableAndIsWritable(existingFile));
  }

  @Test
  void fileExists_DoesNotThrowExceptions_WhenFileExists() {
    Assertions.assertThrows(PlatformFileNotFoundException.class, () -> fileExists(Paths.get("not_exists").toFile()));
  }

  @Test
  void fileIsReadableAndIsReadableAndIsWritable_ThrowsException_WhenFileIsNotReadable() {
    setNotReadable();
    setNotWritable();
    assertThrows(PlatformFileNotReadableException.class, () -> fileExistsAndIsReadableAndIsWritable(existingFile));
  }

  @Test
  void fileIsReadableAndIsReadableAndIsWritable_ThrowsException_WhenFileIsReadableButNotWritable() {
    setNotWritable();
    setReadable();
    assertThrows(PlatformFileNotWritableException.class, () -> fileExistsAndIsReadableAndIsWritable(existingFile));
  }

  @Test
  void fileExistsAndIsReadableAndIsWritable_Throws_WhenFileDoesNotExist() {
    assertThrows(PlatformFileNotFoundException.class, () -> fileExistsAndIsReadableAndIsWritable(Paths.get("not_exists").toFile()));
  }

  @Test
  @DisabledOnOs(OS.WINDOWS)
  void pathIsAbsolute_DoesNotThrowExceptions_WhenPathIsAbsoluteAndIsLinuxPath() {
    Assertions.assertDoesNotThrow(() -> pathIsAbsolute(Paths.get("/usr/s")));
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void pathIsAbsolute_DoesNotThrowExceptions_WhenPathIsAbsoluteAndIsWindowsPath() {
    Assertions.assertDoesNotThrow(() -> pathIsAbsolute(Paths.get("C:\\Program Files\\")));
  }

  @Test
  void pathIsAbsolute_ThrowsException_WhenPathIsNotAbsolute() {
    assertThrows(RelativePathNotAllowedException.class, () -> pathIsAbsolute(Paths.get("s/dd")));
  }

  @Test
  void pathIsAbsolute_ThrowsException_WhenPathIsEmpty() {
    assertThrows(RelativePathNotAllowedException.class, () -> pathIsAbsolute(Paths.get("")));
  }

  @Test
  void positiveRangeBoundariesAreCorrect_ThrowsException_WhenLowerBoundIsNegativeAndArgumentsAreInts() {
    assertThrows(IllegalArgumentException.class, () -> positiveRangeBoundariesAreCorrect(-1, 20));
  }

  @Test
  void positiveRangeBoundariesAreCorrect_ThrowsException_WhenLowerBoundIsNegativeAndArgumentsAreLongs() {
    assertThrows(IllegalArgumentException.class, () -> positiveRangeBoundariesAreCorrect(-1L, 20L));
  }

  @Test
  void positiveRangeBoundariesAreCorrect_ThrowsException_WhenUpperBoundIsSmallerThanLowerBoundAndArgumentsAreInts() {
    assertThrows(IllegalArgumentException.class, () -> positiveRangeBoundariesAreCorrect(15, 11));
  }

  @Test
  void positiveRangeBoundariesAreCorrect_ThrowsException_WhenUpperBoundIsSmallerThanLowerBoundAndArgumentsAreLongs() {
    assertThrows(IllegalArgumentException.class, () -> positiveRangeBoundariesAreCorrect(20L, 8L));
  }

  @Test
  void positiveRangeBoundariesAreCorrect_ThrowsException_WhenUpperBoundIsEqualToLowerBoundAndArgumentsAreInts() {
    assertThrows(IllegalArgumentException.class, () -> positiveRangeBoundariesAreCorrect(11, 11));
  }

  @Test
  void positiveRangeBoundariesAreCorrect_ThrowsException_WhenUpperBoundIsEqualToLowerBoundAndArgumentsAreLongs() {
    assertThrows(IllegalArgumentException.class, () -> positiveRangeBoundariesAreCorrect(8L, 8L));
  }

  private void setNotWritable() {
    existingFile.setWritable(false, false);
  }

  private void setWritable() {
    existingFile.setWritable(true, false);
  }

  private void setNotReadable() {
    existingFile.setReadable(false, false);
  }

  private void setReadable() {
    existingFile.setReadable(true, false);
  }

  private File getCurrentDirectory() {
    return Paths.get(".").toFile();
  }

  private File createNewFileInCurrentDirectory() throws IOException {
    Path existing = Paths.get("exists").toAbsolutePath();
    final File file = existing.toFile();
    file.createNewFile();
    return file;
  }
}