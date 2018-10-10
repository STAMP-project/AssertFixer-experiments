package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyClosedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyDeletedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;

import java.util.List;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageDirectoryDescriptor extends StorageRecordDescriptor {

  /**
   * Number of records in this directory.
   *
   * @return number of entries.
   */
  int numberOfEntries();

  @Override
  default boolean isDirectory() {
    return true;
  }

  @Override
  default boolean isFile() {
    return false;
  }

  /**
   * Create recursively the directory on the associated {@link StorageFileSystem} that is a child of this directory and has provided {@link StoragePath}.
   * Note that the created descriptor should be closed after usage.
   *
   * @param storagePath full {@link StoragePath} of the directory to create..
   * @return Initialized instance of {@link StorageDirectoryDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this name already exist in this directory.
   */
  StorageDirectoryDescriptor createChildDirectoryRecursively(final StoragePath storagePath);

  /**
   * Create directory on the associated {@link StorageFileSystem} that is a child of this directory.
   * Note that the created descriptor should be closed after usage.
   *
   * @param directoryName name of the directory to create.
   * @return Initialized instance of {@link StorageDirectoryDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this name already exist in this directory.
   */
  StorageDirectoryDescriptor createChildDirectory(final String directoryName);

  /**
   * Create file on this {@link StorageFileSystem}.
   * Note that the created descriptor should be closed after usage.
   *
   * @param filename name of the file to create.
   * @return Initialized instance of {@link StorageFileDescriptor} object.
   * @throws StorageRecordAlreadyExistsException if record with this name already exists in this directory.
   */
  StorageFileDescriptor createChildFile(final String filename);

  /**
   * Get {@link List<StoragePath>} that are children of this directory.
   *
   * @return {@link List<StoragePath>} that are children of this directory.
   * @throws StorageRecordAlreadyClosedException  if this descriptor has already been closed.
   * @throws StorageRecordAlreadyDeletedException if the directory for this descriptor has already been deleted.
   */
  List<StoragePath> listChildren();

  /**
   * Search for a descendant of this directory by provided {@link StoragePath}.
   * Note that the created descriptor should be closed after usage.
   *
   * @param path full {@link StoragePath} of the directory to find.
   * @return opened {@link StorageRecordDescriptor}.
   */
  StorageRecordDescriptor search(StoragePath path);
}
