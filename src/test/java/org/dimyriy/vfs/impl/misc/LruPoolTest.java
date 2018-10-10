package org.dimyriy.vfs.impl.misc;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.Closeable;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 30.09.18
 */
class LruPoolTest {
  private Closeable firstPoolObject = null;
  private LruPool<Closeable> pool = null;

  @BeforeEach
  void setUp() {
    firstPoolObject = Mockito.mock(Closeable.class);
    pool = new LruPool<>(1, () -> () -> {
    });
  }

  @Test
  void close_CallsCloseOnAllObjectsInPool() throws IOException {
    pool = new LruPool<>(3, () -> () -> {
    });
    final Closeable secondObject = Mockito.mock(Closeable.class);
    final Closeable thirdObject = Mockito.mock(Closeable.class);
    pool.putObject(firstPoolObject);
    pool.putObject(secondObject);
    pool.putObject(thirdObject);
    Mockito.verify(firstPoolObject, Mockito.times(0)).close();
    Mockito.verify(secondObject, Mockito.times(0)).close();
    Mockito.verify(thirdObject, Mockito.times(0)).close();
    pool.close();
    Mockito.verify(firstPoolObject, Mockito.times(1)).close();
    Mockito.verify(secondObject, Mockito.times(1)).close();
    Mockito.verify(thirdObject, Mockito.times(1)).close();
  }

  @Test
  void close_RethrowsSameException_WhenClosingResourceThrowsException() throws IOException {
    final IOException e = new IOException("oops");
    Mockito.doThrow(e).when(firstPoolObject).close();
    pool.putObject(firstPoolObject);
    try {
      pool.close();
    } catch (final IOException thrown) {
      AssertionsForClassTypes.assertThat(thrown).isSameAs(e);
    }
    Mockito.verify(firstPoolObject, Mockito.times(1)).close();
  }

  @Test
  void borrow_ReturnsSameObject_WhenItExistsInPool() {
    pool.putObject(firstPoolObject);
    final Closeable object = pool.borrowObject();
    assertThat(object).isSameAs(firstPoolObject);
  }

  @Test
  void borrow_ReturnsDifferentObject_WhenPoolIsEmpty() {
    pool.putObject(firstPoolObject);
    pool.borrowObject();
    final Closeable newObject = pool.borrowObject();
    assertThat(newObject).isNotNull();
    assertThat(newObject).isNotEqualTo(firstPoolObject);
  }

  @Test
  void borrow_ReturnsLastAddedObject_WhenPoolSizeIsOne_AndCallsCloseOnExpiredEntry() throws IOException {
    pool.putObject(firstPoolObject);
    pool.borrowObject();
    final Closeable secondObject = Mockito.mock(Closeable.class);
    pool.putObject(secondObject);
    final Closeable secondPoolObject = pool.borrowObject();
    assertThat(secondPoolObject).isNotNull().isNotEqualTo(firstPoolObject).isEqualTo(secondObject);
    assertThat(pool.borrowObject()).isNotEqualTo(secondPoolObject).isNotEqualTo(firstPoolObject);
    Mockito.verify(firstPoolObject, Mockito.times(0)).close();
    Mockito.verify(secondObject, Mockito.times(0)).close();
  }

  @Test
  void put_CallsCloseAndRemovesLruObject_WhenSizeLimitExceeded() throws IOException {
    pool.putObject(firstPoolObject);
    final Closeable secondObject = Mockito.mock(Closeable.class);
    pool.putObject(secondObject);
    Mockito.verify(firstPoolObject, Mockito.times(1)).close();
    Mockito.verify(secondObject, Mockito.times(0)).close();
  }
}