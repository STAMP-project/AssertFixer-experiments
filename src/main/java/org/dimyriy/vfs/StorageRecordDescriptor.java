package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.StorageEntryHeader;
import org.dimyriy.vfs.impl.exceptions.StorageDirectoryNotEmptyException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;

/**
 * Abstract interface for the open descriptor of file or directory on {@link StorageFileSystem}.
 * Note that this descriptor is intended to be closed right after usage so it's a good practice to wrap all the creations in try-with-resources.
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
  StorageEntryHeader header();

  /**
   * @return {@link StorageFileSystem} on which this file or directory has been created.
   */
  StorageFileSystem fs();

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
   * Check whether this descriptor is closed.
   *
   * @return true if descriptor is closed.
   */
  boolean isClosed();

  @Override
  void close();

  /**
   * Get filename.
   *
   * @return filename of file accessed by this file or directory descriptor.
   */
  String getFilename();
}
