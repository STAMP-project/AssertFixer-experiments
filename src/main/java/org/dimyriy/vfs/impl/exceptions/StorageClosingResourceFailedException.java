package org.dimyriy.vfs.impl.exceptions;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class StorageClosingResourceFailedException extends StorageException {
  public StorageClosingResourceFailedException(final Exception cause) {
    super(cause);
  }
}
