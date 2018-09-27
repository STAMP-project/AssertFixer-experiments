package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.guards.Assertions;

import javax.annotation.Nonnull;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.dimyriy.vfs.impl.constants.StorageConstants.SEPARATOR;

/**
 * Holds the unix-like absolute path that is used as path to the records in {@link StorageFileSystem}.
 *
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public final class StoragePath {
  private static final Pattern PATH_SPLIT_PATTERN = Pattern.compile(String.valueOf(SEPARATOR));
  private final String unixPath;
  private StoragePath parentPath = null;

  /**
   * @param unixPath Unix-like absolute path separated by {@link StorageFileSystem#separator()} that leads
   *                 leading to a new or existing {@link StorageRecord} on {@link StorageFileSystem}.
   *                 See {@link StorageFileSystem#allowedPathPattern()} for the range of allowed characters.
   */
  public StoragePath(@Nonnull final String unixPath) {
    Assertions.matchesPathPattern(unixPath);
    this.unixPath = unixPath;
  }

  public final StorageRecord toRecord(@Nonnull final StorageFileSystem storageFileSystem) {
    return storageFileSystem.find(this);
  }

  public final StoragePath child(@Nonnull final String filename) {
    Assertions.matchesFilenamePattern(filename);
    return new StoragePath(this.unixPath + SEPARATOR + filename);
  }

  public final synchronized StoragePath parent() {
    if (isRoot()) {
      return null;
    }
    if (parentPath == null) {
      parentPath = new StoragePath(unixPath.substring(0, unixPath.indexOf(unixPath)));
    }
    return parentPath;
  }

  public final boolean isRoot() {
    return unixPath.equals(StorageConstants.ROOT_DIRECTORY_UNIX_PATH);
  }

  public final Stream<String> pathWalker() {
    if (isRoot()) {
      return Stream.empty();
    }
    return PATH_SPLIT_PATTERN.splitAsStream(unixPath);
  }

  @Override
  public String toString() {
    return "StoragePath{" +
      "unixPath='" + unixPath + '\'' +
      '}';
  }
}
