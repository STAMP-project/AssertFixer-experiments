package org.dimyriy.vfs.impl.util;

import org.dimyriy.vfs.impl.exceptions.InitializationException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public final class FileUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
  private static final List<String> NON_LOCAL_FILE_STORES = Arrays.asList("nfs", "cifs", "fuse", "smbfs");

  private FileUtil() {
  }

  public static String toAbsolutePath(@Nonnull final String absolutePath, @Nonnull final String filename) {
    return absolutePath + FileSystems.getDefault().getSeparator() + filename;
  }

  public static File createFileInstanceForStorageFileSystem(@Nonnull final String absolutePathToParentDirectory, @Nonnull final String filename) {
    return createFileInstanceForStorageFileSystem(Paths.get(absolutePathToParentDirectory), filename);
  }

  private static boolean guessIfPathIsNotLocal(@Nonnull final Path path) throws IOException {
    final String type = Files.getFileStore(path).type();
    return NON_LOCAL_FILE_STORES.stream().anyMatch(type::contains);
  }

  private static File createFileInstanceForStorageFileSystem(@Nonnull final Path parentDirectory, @Nonnull final String filename) {
    Assertions.pathIsAbsolute(parentDirectory);
    Assertions.pathDoesNotContainSymbolicLinks(parentDirectory);
    try {
      if (FileUtil.guessIfPathIsNotLocal(parentDirectory)) {
        LOGGER.warn("Looks like trying to create a file system on a remote path {}", parentDirectory);
      }
    } catch (final IOException e) {
      throw new InitializationException("Failed to check is path is local or remote", e);
    }
    final File parent = parentDirectory.toFile();
    Assertions.isDirectoryAndExists(parent);
    return new File(parent, filename);
  }
}
