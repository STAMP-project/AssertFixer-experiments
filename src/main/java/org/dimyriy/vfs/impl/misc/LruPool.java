package org.dimyriy.vfs.impl.misc;

import org.dimyriy.vfs.impl.GuarderProcessor;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.Closeable;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

/**
 * @author Dmitrii Bogdanov
 * Created at 30.09.18
 */
public class LruPool<T extends Closeable> implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(LruPool.class);
  private final GuarderProcessor processor = new GuarderProcessor.Blocking();
  private final Set<T> lruSet;
  private final Supplier<T> objectFactory;

  public LruPool(final int size, @Nonnull final Supplier<T> objectFactory) {
    lruSet = Collections.newSetFromMap(new LinkedHashMap<T, Boolean>(size + 1,
                                                                     .75f,
                                                                     true) {
      @Override
      protected boolean removeEldestEntry(@Nonnull final Map.Entry<T, Boolean> eldest) {
        if (size() > size) {
          try {
            eldest.getKey().close();
          } catch (final IOException e) {
            LOGGER.warn("Got exception while closing eldest entry", e);
          }
          return true;
        } else {
          return false;
        }
      }
    });
    this.objectFactory = objectFactory;
  }

  @Override
  public void close() throws IOException {
    LOGGER.trace("Closing LruPool started");
    final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
    this.lruSet.forEach(closeable -> ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, closeable));
    if (thrown.getValue() != null) {
      LOGGER.warn("Closing LruPool failed", thrown.getValue());
      throw thrown.getValue();
    }
    LOGGER.trace("Closing LruPool finished");
  }

  public T borrowObject() {
    return processor.create(() -> {
      final Optional<T> any = lruSet.stream().findAny();
      any.ifPresent(lruSet::remove);
      return any.orElseGet(objectFactory);
    });
  }

  public void putObject(@Nonnull final T object) {
    processor.write(() -> lruSet.add(object));
  }
}
