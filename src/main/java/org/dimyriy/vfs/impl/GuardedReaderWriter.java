package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.misc.NoArgFunction;
import org.dimyriy.vfs.impl.misc.NoArgVoid;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
class GuardedReaderWriter {
  private final ReadWriteLock guard = new ReentrantReadWriteLock();

  <T> T executeReadOperation(final NoArgFunction<T> read) {
    guard.readLock().lock();
    try {
      return read.apply();
    } finally {
      guard.readLock().unlock();
    }
  }

  void executeWriteOperation(final NoArgVoid write) {
    guard.writeLock().lock();
    try {
      write.apply();
    } finally {
      guard.writeLock().unlock();
    }
  }

  <T> T executeCreateOperation(final NoArgFunction<T> create) {
    guard.writeLock().lock();
    try {
      return create.apply();
    } finally {
      guard.writeLock().unlock();
    }
  }
}
