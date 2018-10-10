package org.dimyriy.vfs.impl.util;

import org.assertj.core.api.Assertions;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Dmitrii Bogdanov
 * Created at 01.10.18
 */
class ExceptionUtilTest {
  private Closeable closeable = null;

  @BeforeEach
  void setUp() {
    closeable = Mockito.mock(Closeable.class);
  }

  @Test
  void closeAndStoreExceptionIfOccurred_StoresExceptionInHolder_WhenCloseThrownException() throws IOException {
    final IOException ioException = new IOException();
    final SimpleObjectHolder<IOException> exceptionHolder = new SimpleObjectHolder<>(null);
    Mockito.doThrow(ioException).when(closeable).close();
    ExceptionUtil.closeAndStoreExceptionIfOccurred(exceptionHolder, closeable);
    Assertions.assertThat(exceptionHolder.getValue()).isSameAs(ioException);
  }

  @Test
  void closeAndStoreExceptionIfOccurred_StoresSecondExceptionAsSuppressedOfFirst_WhenSecondCloseThrownException() throws IOException {
    final IOException firstException = new IOException();
    final IOException secondException = new IOException();
    final SimpleObjectHolder<IOException> exceptionHolder = new SimpleObjectHolder<>(null);
    Mockito.doThrow(firstException).when(closeable).close();
    final Closeable secondCloseable = Mockito.mock(Closeable.class);
    Mockito.doThrow(secondException).when(secondCloseable).close();
    ExceptionUtil.closeAndStoreExceptionIfOccurred(exceptionHolder, closeable);
    ExceptionUtil.closeAndStoreExceptionIfOccurred(exceptionHolder, secondCloseable);
    Assertions.assertThat(exceptionHolder.getValue()).isSameAs(firstException);
    Assertions.assertThat(Objects.requireNonNull(exceptionHolder.getValue()).getSuppressed().length).isEqualTo(1);
    Assertions.assertThat(exceptionHolder.getValue().getSuppressed()[0]).isSameAs(secondException);
  }

  @Test
  void closeAndStoreExceptionIfOccurred_StoresNothing_WhenCloseDoesNotThrowException() throws IOException {
    final SimpleObjectHolder<IOException> exceptionHolder = new SimpleObjectHolder<>(null);
    Mockito.doNothing().when(closeable).close();
    ExceptionUtil.closeAndStoreExceptionIfOccurred(exceptionHolder, closeable);
    Assertions.assertThat(exceptionHolder.getValue()).isNull();
  }
}