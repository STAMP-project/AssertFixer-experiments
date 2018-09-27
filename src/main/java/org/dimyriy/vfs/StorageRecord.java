package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.exceptions.StorageDirectoryNotEmptyException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyDeletedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public interface StorageRecord {

  /**
   * @return name of file or directory
   */
  String getFilename();

  /**
   * @return {@link StorageFileSystem} with which this file or directory has been associated.
   */
  StorageFileSystem getStorageFileSystem();

  /**
   * @return {@link StoragePath} of this file or directory
   */
  StoragePath getPath();

  /**
   * @return {@link StorageDirectory} that is a parent of file or directory
   */
  StorageDirectory getParent();

  /**
   * Check whether current directory is a directory.
   *
   * @return true if record is a directory.
   */
  boolean isDirectory();

  /**
   * Check whether current directory is a regular file.
   *
   * @return true if record is a regular file.
   */
  boolean isFile();

  /**
   * Check whether current directory has been deleted.
   *
   * @return true if current directory has been deleted.
   */
  boolean isDeleted();

  /**
   * Create the file or directory on the underlying storage.
   *
   * @throws StorageRecordAlreadyExistsException if file with the same name already exists.
   */
  void create() throws StorageRecordAlreadyExistsException;

  /**
   * Delete the file or directory from the underlying storage.
   *
   * @throws StorageRecordDoesNotExistException if the file or directory doesn't exist.
   * @throws StorageDirectoryNotEmptyException  if the record is a directory and not empty.
   */
  void delete() throws StorageRecordDoesNotExistException, StorageDirectoryNotEmptyException;

  /**
   * Rename current file or directory. If the file or directory hasn't been created yet or has already been removed
   * this method makes no changes on the underlying storage.
   *
   * @param newName new name for a file or directory.
   * @throws StorageRecordAlreadyExistsException  if file or directory with new name already exist in the same directory.
   * @throws StorageRecordAlreadyDeletedException when trying to rename file that has been already deleted.
   */
  void rename(@Nonnull final String newName) throws StorageRecordAlreadyExistsException, StorageRecordAlreadyDeletedException;
}
