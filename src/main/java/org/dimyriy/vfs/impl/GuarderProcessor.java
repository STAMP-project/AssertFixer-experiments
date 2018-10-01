package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.misc.NoArgVoid;

import javax.annotation.Nonnull;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface GuarderProcessor {

  <T> T read(@Nonnull Supplier<T> read);

  void write(NoArgVoid write);

  <T> T create(@Nonnull Supplier<T> create);

  class Blocking implements GuarderProcessor {
    private final Lock guard = new ReentrantLock();

    @Override
    public <T> T read(@Nonnull final Supplier<T> read) {
      guard.lock();
      try {
        return read.get();
      } finally {
        guard.unlock();
      }
    }

    @Override
    public void write(final NoArgVoid write) {
      guard.lock();
      try {
        write.apply();
      } finally {
        guard.unlock();
      }
    }

    @Override
    public <T> T create(@Nonnull final Supplier<T> create) {
      guard.lock();
      try {
        return create.get();
      } finally {
        guard.unlock();
      }
    }
  }

  class RWLockBlocking implements GuarderProcessor {
    private final ReadWriteLock guard = new ReentrantReadWriteLock();

    @Override
    public <T> T read(@Nonnull final Supplier<T> read) {
      guard.readLock().lock();
      try {
        return read.get();
      } finally {
        guard.readLock().unlock();
      }
    }

    @Override
    public void write(final NoArgVoid write) {
      guard.writeLock().lock();
      try {
        write.apply();
      } finally {
        guard.writeLock().unlock();
      }
    }

    @Override
    public <T> T create(@Nonnull final Supplier<T> create) {
      guard.writeLock().lock();
      try {
        return create.get();
      } finally {
        guard.writeLock().unlock();
      }
    }
  }

}
