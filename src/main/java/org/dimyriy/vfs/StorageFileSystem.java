package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;

import javax.annotation.Nonnull;
import java.io.Closeable;

/**
 * Common object that is being associated with all the created records and files.
 * Note that you can create more than one instance of {@link StorageFileSystem}. See {@link StorageFileSystemFactory} for details.
 *
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageFileSystem extends Closeable {

  /**
   * Get number of remaining empty clusters in this {@link StorageFileSystem}
   *
   * @return number of remaining empty clusters
   */
  long getFreeSpace();

  /**
   * Root path of this {@link StorageFileSystem}
   *
   * @return {@link StoragePath}
   */
  StoragePath rootPath();

  /**
   * Create instance of {@link StoragePath}. Doesn't modify underlying storage.
   *
   * @param unixPath Unix-like path on file system.
   * @see StoragePath
   */
  StoragePath createPath(final String unixPath);

  /**
   * Open the file or directory on this {@link StorageFileSystem}.
   *
   * @param path path of the record to open.
   * @return Initialized instance of {@link StorageRecordDescriptor}.
   * @throws StorageRecordAlreadyExistsException if record with this path doesn't exist.
   */
  StorageRecordDescriptor open(@Nonnull StoragePath path);

  /**
   * Create directory on this {@link StorageFileSystem} recursively.
   * Note that created directory should be closed after usage.
   *
   * @param path path of the directory.
   * @return Initialized instance of {@link StorageDirectoryDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exist.
   * @throws StorageRecordDoesNotExistException  if any intermediate paths weren't a directory.
   */

  StorageDirectoryDescriptor createDirectoryRecursively(@Nonnull StoragePath path);

  /**
   * Create file on this {@link StorageFileSystem} recursively.
   * Note that created file should be closed after usage.
   *
   * @param path path of the file to create.
   * @return Initialized instance of {@link StorageFileDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exist.
   * @throws StorageRecordDoesNotExistException  if any intermediate paths weren't a directory.
   */

  StorageFileDescriptor createFileRecursively(@Nonnull StoragePath path);

  /**
   * Path separator used for this {@link StorageFileSystem}.
   *
   * @return path separator.
   */
  static char separator() {
    return StorageConstants.SEPARATOR;
  }
}
