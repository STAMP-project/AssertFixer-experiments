package org.dimyriy.vfs.impl.util;

import org.dimyriy.vfs.impl.guards.Assertions;

import javax.annotation.Nonnull;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public final class PlatformFileUtil {
  private PlatformFileUtil() {
  }

  public static String toAbsolutePath(@Nonnull final String absolutePath, @Nonnull final String filename) {
    return absolutePath + FileSystems.getDefault().getSeparator() + filename;
  }

  public static File createRegularFileInstance(@Nonnull final String absolutePathToParentDirectory, @Nonnull final String filename) {
    return createRegularFileInstance(Paths.get(absolutePathToParentDirectory), filename);
  }

  static File createRegularFileInstance(@Nonnull final Path parentDirectory, @Nonnull final String filename) {
    Assertions.pathIsAbsolute(parentDirectory);
    final File parent = parentDirectory.toFile();
    Assertions.isDirectoryAndExists(parent);
    return new File(parent, filename);
  }
}
