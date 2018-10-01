package org.dimyriy.vfs.impl.exceptions;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 30.09.18
 */
public class InitializationException extends RuntimeException {
  public InitializationException(final Throwable cause) {
    super(cause);
  }

  public InitializationException(@Nonnull final String message) {
    super(message);
  }

  public InitializationException(@Nonnull final String message, @Nonnull final Throwable cause) {
    super(message, cause);
  }
}
