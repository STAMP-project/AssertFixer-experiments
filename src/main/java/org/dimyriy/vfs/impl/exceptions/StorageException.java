package org.dimyriy.vfs.impl.exceptions;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
class StorageException extends RuntimeException {
  StorageException() {
  }

  StorageException(final String s) {
    super(s);
  }

  StorageException(@Nonnull final Throwable cause) {
    super(cause);
  }
}
