package org.dimyriy.vfs.impl.exceptions;

import java.io.IOException;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public class StorageIOException extends StorageException {
  public StorageIOException(final IOException cause) {
    super(cause);
  }
}
