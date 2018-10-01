package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;

import javax.annotation.Nonnull;
import java.io.Closeable;
import java.util.List;

/**
 * Common object that is being associated with all the created records and files.
 * Note that you can create more than one instance of {@link StorageFileSystem}. See {@link StorageFileSystemFactory} for details.
 * //TODO: more detailed javadoc
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
  int getFreeSpace();

  /**
   * Root path of this {@link StorageFileSystem}
   *
   * @return {@link StoragePath}
   */
  StoragePath root();

  /**
   * Create instance of {@link StoragePath}. Doesn't modify underlying storage.
   *
   * @param unixPath Unix-like path on file system.
   * @see StoragePath
   */
  StoragePath createPath(final String unixPath);

  /**
   * Create directory on this {@link StorageFileSystem}.
   * Note that created directory should be closed after usage.
   *
   * @param path path of the directory.
   * @return Initialized instance of {@link StorageDirectoryDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exist.
   */
  StorageDirectoryDescriptor createDirectory(@Nonnull StoragePath path);

  /**
   * Create directory on this {@link StorageFileSystem} recursively.
   * Note that created directory should be closed after usage.
   *
   * @param path path of the directory.
   * @return Initialized instance of {@link StorageDirectoryDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exist.
   */
  StorageDirectoryDescriptor createDirectoryRecursively(@Nonnull StoragePath path);

  /**
   * Returns list of child paths of this directory.
   *
   * @param directoryDescriptor {@link StorageDirectoryDescriptor} to list child for.
   * @return {@link List<StoragePath>} children of this directory.
   */
  List<StoragePath> listChildren(@Nonnull StorageDirectoryDescriptor directoryDescriptor);

  /**
   * Create file on this {@link StorageFileSystem}.
   * Note that created directory should be closed after usage.
   *
   * @param path path of the file.
   * @return Initialized instance of {@link StorageFileDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exists.
   */
  StorageFileDescriptor createFile(@Nonnull StoragePath path);

  /**
   * Open the file or directory on this {@link StorageFileSystem}.
   *
   * @param path path of the record to open.
   * @return Initialized instance of {@link StorageRecordDescriptor}.
   * @throws StorageRecordAlreadyExistsException if record with this path doesn't exist.
   */
  StorageRecordDescriptor open(@Nonnull StoragePath path);

  /**
   * Deletes the record on this {@link StorageFileSystem}.
   *
   * @param storageRecordDescriptor {@link StorageRecordDescriptor} to delete.
   */
  void delete(@Nonnull StorageRecordDescriptor storageRecordDescriptor);

  /**
   * Updates the name of the record on this {@link StorageFileSystem}.
   *
   * @param storageRecordDescriptor {@link StorageRecordDescriptor} to rename.
   * @param newName                 new name of the record.
   */
  void rename(@Nonnull StorageRecordDescriptor storageRecordDescriptor, @Nonnull String newName);

  /**
   * Path separator used for this {@link StorageFileSystem}.
   *
   * @return path separator.
   */
  static char separator() {
    return StorageConstants.SEPARATOR;
  }
}
