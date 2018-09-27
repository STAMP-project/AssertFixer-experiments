package org.dimyriy.vfs;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageDirectory extends StorageRecord {
  @Override
  default boolean isDirectory() {
    return true;
  }

  @Override
  default boolean isFile() {
    return false;
  }

  /**
   * Create child directory in this directory. Directory will not be written on disk until {@link StorageFile#create()} is called.
   *
   * @param directoryName name of the directory to create.
   * @return Initialized instance of directory
   */
  StorageDirectory createDirectory(final String directoryName);

  /**
   * Create child file in this directory. File will not be written on disk until {@link StorageFile#create()} is called.
   *
   * @param filename name of the file to create.
   * @return Initialized instance of file.
   */
  StorageFile createFile(final String filename);
}
