package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyClosedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyDeletedException;

import java.util.List;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageDirectoryDescriptor extends StorageRecordDescriptor {

  @Override
  default boolean isDirectory() {
    return true;
  }

  @Override
  default boolean isFile() {
    return false;
  }

  /**
   * Create child directory in this directory.
   *
   * @param directoryName name of the directory to create.
   * @return Initialized instance of directory.
   * @throws StorageRecordAlreadyClosedException  if this descriptor has already been closed.
   * @throws StorageRecordAlreadyDeletedException if the directory for this descriptor has already been deleted.
   */
  StorageDirectoryDescriptor createChildDirectory(final String directoryName);

  /**
   * Create empty file in this directory.
   *
   * @param filename name of the file to create.
   * @return Initialized instance of file.
   * @throws StorageRecordAlreadyClosedException  if this descriptor has already been closed.
   * @throws StorageRecordAlreadyDeletedException if the directory for this descriptor has already been deleted.
   */
  StorageFileDescriptor createChildFile(final String filename);

  /**
   * Get {@link List<StoragePath>} of {@link StoragePath} of files in this directory.
   *
   * @return {@link List<StoragePath>} that are children of this directory.
   * @throws StorageRecordAlreadyClosedException  if this descriptor has already been closed.
   * @throws StorageRecordAlreadyDeletedException if the directory for this descriptor has already been deleted.
   */
  List<StoragePath> listChildren();
}
