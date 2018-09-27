package org.dimyriy.vfs;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageFile extends StorageRecord {
  @Override
  default boolean isDirectory() {
    return false;
  }

  @Override
  default boolean isFile() {
    return true;
  }

  /**
   * Fully read content of the file to byte array.
   *
   * @return file content.
   */
  byte[] readContent();

  /**
   * Write byte array to the beginning of the file. This will overwrite existing content.
   *
   * @param content file content
   */
  void writeContent(final byte[] content);
}
