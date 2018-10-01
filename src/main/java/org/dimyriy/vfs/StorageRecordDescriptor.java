package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.StorageEntryHeader;
import org.dimyriy.vfs.impl.exceptions.StorageDirectoryNotEmptyException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyClosedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;

import javax.annotation.Nonnull;

/**
 * Abstract interface for the open descriptor of file or directory on {@link StorageFileSystem}.
 * TODO: add more detailed README
 *
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public interface StorageRecordDescriptor extends AutoCloseable {

  /**
   * Get modification time of entry in milliseconds since epoch.
   *
   * @return modification time of entry in milliseconds since epoch.
   */
  long getModificationUnixTime();

  /**
   * Returns header to which this descriptor points.
   *
   * @return {@link StorageEntryHeader} pointed by descriptor.
   */
  StorageEntryHeader getHeader();

  /**
   * @return {@link StorageFileSystem} on which this file or directory has been created.
   */
  StorageFileSystem getStorageFileSystem();

  /**
   * @return {@link StoragePath} of this file or directory
   */
  StoragePath getPath();

  /**
   * Check whether current descriptor is a directory descriptor.
   *
   * @return true if record is a directory.
   */
  boolean isDirectory();

  /**
   * Check whether current descriptor is a regular file descriptor.
   *
   * @return true if record is a regular file.
   */
  boolean isFile();

  /**
   * Delete the file or directory on the underlying storage.
   *
   * @throws StorageRecordDoesNotExistException if the file or directory doesn't exist.
   * @throws StorageDirectoryNotEmptyException  if the record is a directory and not empty.
   */
  void delete();

  /**
   * Rename current file or directory on the underlying storage.
   *
   * @param newName new name for a file or directory.
   * @throws StorageRecordDoesNotExistException  if the file or directory doesn't exist.
   * @throws StorageRecordAlreadyExistsException if file or directory with new name already exist in the same directory.
   * @throws StorageRecordAlreadyClosedException if this descriptor already closed.
   */
  void rename(@Nonnull final String newName);

  /**
   * Check whether this descriptor is closed.
   *
   * @return true if descriptor is closed.
   */
  boolean isClosed();

  @Override
  void close();
}
