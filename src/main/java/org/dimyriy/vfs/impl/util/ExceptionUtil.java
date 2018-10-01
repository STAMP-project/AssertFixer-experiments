package org.dimyriy.vfs.impl.util;

import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.Closeable;
import java.io.IOException;

/**
 * @author Dmitrii Bogdanov
 * Created at 01.10.18
 */
public final class ExceptionUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtil.class);

  private ExceptionUtil() {
  }

  public static void closeAndStoreExceptionIfOccurred(@Nonnull final SimpleObjectHolder<IOException> exceptionHolder, @Nonnull final Closeable closeable) {
    try {
      closeable.close();
    } catch (final IOException e) {
      LOGGER.trace("Closing " + closeable.getClass() + " failed", e);
      if (exceptionHolder.getValue() == null) {
        exceptionHolder.setValue(e);
      } else {
        exceptionHolder.getValue().addSuppressed(e);
      }
    }
  }
}
