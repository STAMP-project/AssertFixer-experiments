package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;

import static org.dimyriy.vfs.impl.constants.StorageConstants.FILENAME_ALLOWED_CHARACTERS_PATTERN;

/**
 * Common object that is being associated with all the created records and files.
 * Note that you can create more than one instance of {@link StorageFileSystem}. See {@link StorageFileSystemFactory} for details.
 *
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageFileSystem extends AutoCloseable {
  /**
   * Create directory associated with this file system on provided path.
   *
   * @param path path of the directory.
   * @return Initialized instance of {@link StorageDirectory} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exist.
   */
  StorageDirectory createDirectory(final StoragePath path) throws StorageRecordAlreadyExistsException;

  /**
   * Create file associated with this file system on provided path.
   *
   * @param path path of the file.
   * @return Initialized instance of {@link StorageFile} object.
   * @throws StorageRecordAlreadyExistsException if record with this path already exists.
   */
  StorageFile createFile(final StoragePath path) throws StorageRecordAlreadyExistsException;

  /**
   * Find the file by provided path in filesystem.
   *
   * @param path path of the record to find.
   * @return Initialized instance of {@link StorageRecord}.
   * @throws StorageRecordAlreadyExistsException if record with this path doesn't exist.
   */
  StorageRecord find(final StoragePath path) throws StorageRecordDoesNotExistException;

  /**
   * Path separator for this {@link StorageFileSystem}.
   *
   * @return path separator.
   */
  default char separator() {
    return StorageConstants.SEPARATOR;
  }

  /**
   * Pattern that is used to validate the correctness of absolute path on the {@link StorageFileSystem}.
   *
   * @return pattern for allowed absolute path string.
   */
  default String allowedPathPattern() {
    return StorageConstants.PATH_ALLOWED_CHARACTERS_PATTERN;
  }

  /**
   * Pattern that is used to validate the correctness of filename on the {@link StorageFileSystem}.
   *
   * @return pattern for allowed filename string.
   */
  default String allowedFilenamePattern() {
    return FILENAME_ALLOWED_CHARACTERS_PATTERN;
  }
}
