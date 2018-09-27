package org.dimyriy.vfs.impl.guards;

import org.dimyriy.vfs.impl.StorageEntryHeader;
import org.dimyriy.vfs.impl.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;
import java.nio.file.Path;
import java.util.regex.Pattern;

import static org.dimyriy.vfs.impl.constants.StorageConstants.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public final class Assertions {
  private static final Pattern PATH_ALLOWED_CHARACTERS = Pattern.compile(PATH_ALLOWED_CHARACTERS_PATTERN);
  private static final Pattern FILENAME_ALLOWED_CHARACTERS = Pattern.compile(FILENAME_ALLOWED_CHARACTERS_PATTERN);
  private static final Logger LOGGER = LoggerFactory.getLogger(Assertions.class);

  private Assertions() {
  }

  public static void entryHeaderDirectory(@Nonnull final StorageEntryHeader header) {
    if (!header.isDirectory()) {
      throw new StorageEntryHeaderNotDirectoryException();
    }
  }

  public static void assertDirectorySize(final int directorySize) {
    if (directorySize < MAX_DIRECTORY_FILESIZE_IN_BYTES) {
      throw new DirectoryAlreadyContainsMaximumNumberOfFilesException();
    }
  }

  public static void matchesFilenamePattern(@Nonnull final String filename) {
    if (!FILENAME_ALLOWED_CHARACTERS.matcher(filename).matches()) {
      throw new FilenameContainsIllegalCharacters();
    }
  }

  public static void matchesPathPattern(@Nonnull final String fullPath) {
    if (!fullPath.startsWith("/")) {
      throw new RelativePathNotAllowedException();
    }
    if (!PATH_ALLOWED_CHARACTERS.matcher(fullPath).matches()) {
      throw new PathContainsIllegalCharactersException();
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

  public static void pathIsAbsolute(@Nonnull final Path path) {
    if (!path.isAbsolute()) {
      LOGGER.trace("Asserting that path {} is absolute: failed", path);
      throw new RelativePathNotAllowedException();
    }
    LOGGER.trace("Asserting that path {} is absolute: ok", path);
  }

  public static void fileDoesNotExist(@Nonnull final File file) {
    if (file.exists()) {
      LOGGER.trace("Asserting that file {} does not exist: failed", file);
      throw new PlatformFileAlreadyExistsException();
    }
    LOGGER.trace("Asserting that file {} does not exist: ok", file);
  }

  static void isRegularFile(@Nonnull final File file) {
    if (!file.isFile()) {
      LOGGER.trace("Asserting that file {} is regular file: failed", file);
      throw new PlatformFileNotRegularFileException();
    }
    LOGGER.trace("Asserting that file {} is regular file ok", file);
  }

  static void fileExists(@Nonnull final File file) {
    if (!file.exists()) {
      LOGGER.trace("Asserting that file {} exists: failed", file);
      throw new PlatformFileNotFoundException();
    }
    LOGGER.trace("Asserting that file {} exists: ok", file);
  }

  private static void fileIsDirectory(final File file) {
    if (!file.isDirectory()) {
      LOGGER.trace("Asserting that file {} is directory: failed", file);
      throw new PlatformFileNotDirectoryException();
    }
    LOGGER.trace("Asserting that file {} is directory: ok", file);
  }

  private static void fileIsReadable(@Nonnull final File file) {
    if (!file.canRead()) {
      LOGGER.trace("Asserting that file {} is readable: failed", file);
      throw new PlatformFileNotReadableException();
    }
    LOGGER.trace("Asserting that file {} is readable: ok", file);
  }

  private static void fileIsWritable(@Nonnull final File file) {
    if (!file.canWrite()) {
      LOGGER.trace("Asserting that file {} is writable: failed", file);
      throw new PlatformFileNotWritableException();
    }
    LOGGER.trace("Asserting that file {} is writable: ok", file);
  }
}
