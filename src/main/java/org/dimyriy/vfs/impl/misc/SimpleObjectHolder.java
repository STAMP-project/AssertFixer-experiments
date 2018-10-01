package org.dimyriy.vfs.impl.misc;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Dmitrii Bogdanov
 * Created at 28.09.18
 */
@ThreadSafe
public class SimpleObjectHolder<T> {
  private final AtomicReference<T> value = new AtomicReference<>();

  public SimpleObjectHolder(@Nullable final T value) {
    this.value.set(value);
  }

  @Nullable
  public T getValue() {
    return value.get();
  }

  public void setValue(@Nullable final T value) {
    this.value.set(value);
  }
}
