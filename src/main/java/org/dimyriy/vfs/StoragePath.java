package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.MaxNestingLevelExceededException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.ByteUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.dimyriy.vfs.impl.constants.StorageConstants.ROOT_DIRECTORY_UNIX_PATH;
import static org.dimyriy.vfs.impl.guards.Assertions.directoryNestingLevelIsNotExceeded;
import static org.dimyriy.vfs.impl.guards.Assertions.pathMatchesPattern;

/**
 * Holds unix-like absolute path that is used as path to the records in {@link StorageFileSystem}.
 * Note that Strings containing non-ascii symbols are not allowed.
 *
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public class StoragePath {
  private static final Pattern pathSplitPattern = Pattern.compile(String.valueOf(StorageFileSystem.separator()));
  private final String unixPath;
  private final StorageFileSystem fs;
  private final int nestingLevel;
  private StoragePath parent;

  /**
   * @param unixPath Unix-like absolute path separated by {@link StorageFileSystem#separator()} that leads
   *                 to a new or existing {@link StorageRecordDescriptor} on {@link StorageFileSystem}.
   *                 Only ascii symbols are allowed.
   * @param fs       {@link StorageFileSystem} to associate with this path.
   * @throws MaxNestingLevelExceededException if nesting level {@link StorageConstants#maxNestedDirectoryLevel()} is exceeded.
   */
  public StoragePath(@Nonnull final String unixPath, @Nonnull final StorageFileSystem fs) {
    this(unixPath, null, fs);
  }

  private StoragePath(@Nonnull final String unixPath, @Nullable final StoragePath parent, @Nonnull final StorageFileSystem fs) {
    pathMatchesPattern(unixPath);
    if (parent == null) {
      this.nestingLevel = nestingLevel(unixPath);
    } else {
      this.nestingLevel = parent.getNestingLevel() + 1;
    }
    directoryNestingLevelIsNotExceeded(this.nestingLevel);
    this.unixPath = unixPath;
    this.fs = fs;
    this.parent = parent;
  }

  /**
   * Open the record with this path on associated {@link StorageFileSystem}.
   *
   * @return {@link StorageRecordDescriptor} if it exists on associated {@link StorageFileSystem}.
   * @throws StorageRecordDoesNotExistException if record doesn't exist on file system.
   */
  public StorageRecordDescriptor open() {
    return fs.open(this);
  }

  /**
   * Create child path. Only ascii symbols are allowed.
   *
   * @param childName name of child record to create path to.
   * @return child {@link StoragePath}.
   */
  public StoragePath child(@Nonnull final String childName) {
    Assertions.filenameMatchesPattern(childName);
    if (isRoot()) {
      return new StoragePath(StorageFileSystem.separator() + childName, this, fs);
    } else {
      return new StoragePath(this.unixPath + StorageFileSystem.separator() + childName, this, fs);
    }
  }

  public String getFilename() {
    return unixPath.substring(unixPath.lastIndexOf(StorageFileSystem.separator()) + 1);
  }

  public StoragePath parent() {
    if (isRoot()) {
      return this;
    }
    if (nestingLevel == 1) {
      return fs.root();
    } else {
      if (parent == null) {
        parent = new StoragePath(unixPath.substring(0, unixPath.lastIndexOf(StorageFileSystem.separator())), fs);
      }
    }
    return parent;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof StoragePath)) return false;
    final StoragePath otherPath = (StoragePath) o;
    return Objects.equals(unixPath, otherPath.unixPath) &&
      Objects.equals(fs, otherPath.fs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unixPath, fs);
  }

  @Override
  public String toString() {
    return unixPath;
  }

  public final boolean isRoot() {
    return unixPath.equals(rootUnixPath());
  }

  public final Stream<byte[]> bytePathWalker() {
    return pathWalker().map(ByteUtil::asciiStringToByteArray);
  }

  public final byte[] byteFilename() {
    return ByteUtil.asciiStringToByteArray(getFilename());
  }

  private int getNestingLevel() {
    return nestingLevel;
  }

  /**
   * Created pathWalker intentionally skips first entry here as the first entry is always root.
   *
   * @return {@link Stream<String>} to traverse from root.
   */
  private Stream<String> pathWalker() {
    if (isRoot()) {
      return Stream.empty();
    }
    return pathSplitPattern.splitAsStream(unixPath).skip(1);
  }

  private int nestingLevel(@Nonnull final String unixPath) {
    return (int) unixPath.codePoints().filter(c -> c == StorageFileSystem.separator()).count();
  }

  private static String rootUnixPath() {
    return ROOT_DIRECTORY_UNIX_PATH;
  }
}
