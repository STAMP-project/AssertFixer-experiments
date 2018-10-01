package org.dimyriy.vfs.impl.misc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 29.09.18
 */
class SimpleObjectHolderTest {

  @Test
  void getValue_ReturnsInitialValue_WhenObjectJustCreated() {
    final Object o = new Object();
    assertThat(new SimpleObjectHolder<>(o).getValue()).isSameAs(o);
  }

  @Test
  void getValue_ReturnsJustSetValue_WhenCalledAfterSetValue() {
    final SimpleObjectHolder<Object> holder = new SimpleObjectHolder<>(new Object());
    final Object newObject = new Object();
    holder.setValue(newObject);
    assertThat(holder.getValue()).isSameAs(newObject);
  }

  @Test
  void getValue_ReturnsJustSetValue_WhenCalledAfterSetValueCalledWithNull() {
    final SimpleObjectHolder<Object> holder = new SimpleObjectHolder<>(new Object());
    holder.setValue(null);
    assertThat(holder.getValue()).isNull();
  }

  @Test
  void getValue_ReturnsNull_WhenCreatedWithNullInitialValue() {
    assertThat(new SimpleObjectHolder<>(null).getValue()).isNull();
  }
}