package org.dimyriy.vfs.impl.exceptions;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
public class StorageRecordAlreadyExistsException extends StorageException {
  public StorageRecordAlreadyExistsException() {
    this("already exists");
  }

  private StorageRecordAlreadyExistsException(final String s) {
    super(s);
  }
}
