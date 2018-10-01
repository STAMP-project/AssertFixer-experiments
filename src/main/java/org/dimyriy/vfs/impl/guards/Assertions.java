package org.dimyriy.vfs.impl.guards;

import org.dimyriy.vfs.impl.StorageEntryHeader;
import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static org.dimyriy.vfs.impl.constants.StorageConstants.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public final class Assertions {
  private static final Pattern DOUBLE_SLASHES = Pattern.compile(DOUBLE_SLASHES_PATTERN);
  private static final Logger LOGGER = LoggerFactory.getLogger(Assertions.class);

  private Assertions() {
  }

  public static void entryHeaderIsDirectory(@Nonnull final StorageEntryHeader header) {
    if (!header.isDirectory()) {
      throw new StorageEntryHeaderNotDirectoryException();
    }
  }

  public static void directorySizeIsNotExceeded(final int directorySize) {
    if (directorySize >= getMaxDirectoryFilesizeInBytes()) {
      throw new DirectoryAlreadyContainsMaximumNumberOfFilesException();
    }
  }

  public static void filenameMatchesPattern(@Nonnull final String filename) {
    if (filename.contains("/") || ByteUtil.stringContainsNonAsciiChars(filename)) {
      throw new FilenameContainsIllegalCharacters();
    }
    if (filename.length() > getMaxFilenameLengthInBytes()) {
      throw new FilenameLengthTooLongException();
    }
  }

  public static void pathMatchesPattern(@Nonnull final String fullPath) {
    if (!fullPath.startsWith("/")) {
      throw new RelativePathsNotAllowedException();
    }
    if (fullPath.equals("/")) {
      return;
    }
    if (!DOUBLE_SLASHES.matcher(fullPath).matches() || ByteUtil.stringContainsNonAsciiChars(fullPath)) {
      throw new PathContainsIllegalCharactersException();
    }
    if (fullPath.length() - fullPath.lastIndexOf(SEPARATOR) > MAX_FILENAME_LENGTH_IN_BYTES) {
      throw new FilenameLengthTooLongException();
    }
  }

  public static void positiveRangeBoundariesAreCorrect(final long lowerBoundClosed, final long upperBoundOpen) {
    if (lowerBoundClosed < 0) {
      throw new IllegalArgumentException("Only positive values allowed");
    }
    if (upperBoundOpen <= lowerBoundClosed) {
      throw new IllegalArgumentException("Upper bound should be strictly greater than lower bound");
    }
  }

  public static void isDirectoryAndExists(@Nonnull final File file) {
    fileExists(file);
    fileIsDirectory(file);
  }

  public static void fileExistsAndIsReadableAndIsWritable(@Nonnull final File file) {
    fileExists(file);
    fileIsReadable(file);
    fileIsWritable(file);
  }

  public static void numberOfOpenDescriptorsIsNotExceeded(final int numberOfOpenDescriptors) {
    if (numberOfOpenDescriptors >= getMaxNumberOfOpenDescriptors()) {
      LOGGER.trace("Max number of open descriptors exceeded");
      throw new MaxNumberOfOpenDescriptorsExceededException();
    }
  }

  public static void pathIsAbsolute(@Nonnull final Path path) {
    if (!path.isAbsolute()) {
      LOGGER.trace("Asserting that path {} is absolute: failed", path);
      throw new InitializationException("relative paths are not allowed");
    }
    LOGGER.trace("Asserting that path {} is absolute: ok", path);
  }

  public static void pathDoesNotContainSymbolicLinks(@Nonnull final Path path) {
    if (Files.isSymbolicLink(path)) {
      LOGGER.trace("Asserting that path {} does not contain symbolic links: failed", path);
      throw new InitializationException("symbolic links are not allowed");
    }
    LOGGER.trace("Asserting that path {} does not contain symbolic links: ok", path);
  }

  public static void fileDoesNotExist(@Nonnull final File file) {
    if (file.exists()) {
      LOGGER.trace("Asserting that file {} does not exist: failed", file);
      throw new InitializationException("file already exists");
    }
    LOGGER.trace("Asserting that file {} does not exist: ok", file);
  }

  public static void directoryNestingLevelIsNotExceeded(final int nestingLevel) {
    if (nestingLevel > maxNestedDirectoryLevel()) {
      throw new MaxNestingLevelExceededException();
    }
  }

  static void isRegularFile(@Nonnull final File file) {
    if (!file.isFile()) {
      LOGGER.trace("Asserting that file {} is regular file: failed", file);
      throw new InitializationException("file is not a regular file");
    }
    LOGGER.trace("Asserting that file {} is regular file ok", file);
  }

  static void fileExists(@Nonnull final File file) {
    if (!file.exists()) {
      LOGGER.trace("Asserting that file {} exists: failed", file);
      throw new InitializationException("file does not exists");
    }
    LOGGER.trace("Asserting that file {} exists: ok", file);
  }

  private static void fileIsDirectory(final File file) {
    if (!file.isDirectory()) {
      LOGGER.trace("Asserting that file {} is directory: failed", file);
      throw new InitializationException("file is not a directory");
    }
    LOGGER.trace("Asserting that file {} is directory: ok", file);
  }

  private static void fileIsReadable(@Nonnull final File file) {
    if (!file.canRead()) {
      LOGGER.trace("Asserting that file {} is readable: failed", file);
      throw new InitializationException("file is not readable");
    }
    LOGGER.trace("Asserting that file {} is readable: ok", file);
  }

  private static void fileIsWritable(@Nonnull final File file) {
    if (!file.canWrite()) {
      LOGGER.trace("Asserting that file {} is writable: failed", file);
      throw new InitializationException("file is not writable");
    }
    LOGGER.trace("Asserting that file {} is writable: ok", file);
  }
}
