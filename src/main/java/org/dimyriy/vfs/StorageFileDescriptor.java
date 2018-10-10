package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyClosedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageFileDescriptor extends StorageRecordDescriptor {
  @Override
  default boolean isDirectory() {
    return false;
  }

  @Override
  default boolean isFile() {
    return true;
  }

  /**
   * File size in bytes.
   *
   * @return file size in bytes.
   */
  int size();

  /**
   * Fully read content of the file to byte array.
   *
   * @return file content.
   */
  byte[] read();

  /**
   * Read {@code length} of the file content at {@code offset} to the provided {@code buffer}.
   *
   * @throws IndexOutOfBoundsException if buffer length is smaller than file length.
   */
  void readAtOffsetToBuffer(final int offset, final int length, final byte[] buffer);

  /**
   * Write byte array content to the beginning of the file. This will overwrite existing content.
   *
   * @param content file content.
   */
  void write(final byte[] content);

  /**
   * Append byte array content to the end of file.
   *
   * @param content file content.
   */
  void append(final byte[] content);

  /**
   * Rename current file on the underlying storage.
   *
   * @param newName new name for a file.
   * @throws StorageRecordDoesNotExistException  if the file or directory doesn't exist.
   * @throws StorageRecordAlreadyExistsException if file or directory with new name already exist in the same directory.
   * @throws StorageRecordAlreadyClosedException if this descriptor already closed.
   */
  void rename(@Nonnull final String newName);
}
