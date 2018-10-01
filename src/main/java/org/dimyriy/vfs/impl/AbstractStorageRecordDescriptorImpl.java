package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.StorageRecordDescriptor;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyClosedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyDeletedException;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public abstract class AbstractStorageRecordDescriptorImpl implements StorageRecordDescriptor {
  private final StoragePath path;
  private final InfileFileSystem owner;
  private final AtomicBoolean isClosed = new AtomicBoolean(false);
  private final AtomicBoolean isDeleted = new AtomicBoolean(false);
  private final StorageEntryHeader header;

  AbstractStorageRecordDescriptorImpl(@Nonnull final StoragePath path, @Nonnull final StorageEntryHeader entryHeader, @Nonnull final InfileFileSystem owner) {
    this.owner = owner;
    this.path = path;
    this.header = entryHeader;
  }

  @Override
  public long getModificationUnixTime() {
    return header.getModificationUnixTime();
  }

  @Override
  public StorageEntryHeader getHeader() {
    return header;
  }

  @Override
  public InfileFileSystem getStorageFileSystem() {
    return this.owner;
  }

  @Override
  public void delete() {
    guardClosed();
    guardDeleted();
    owner.delete(this);
  }

  @Override
  public void rename(@Nonnull final String newName) {
    guardClosed();
    this.getStorageFileSystem().rename(this, newName);
  }

  @Override
  public StoragePath getPath() {
    return path;
  }

  @Override
  public boolean isClosed() {
    return isClosed.get();
  }

  @Override
  public void close() {
    guardClosed();
    owner.executeWrite(() -> {
      guardClosed();
      this.isClosed.set(true);
      owner.closeDescriptor(this);
    });
  }

  void setDeletedFlag() {
    this.isDeleted.set(true);
  }

  void guardClosed() {
    if (isClosed.get()) {
      throw new StorageRecordAlreadyClosedException();
    }
  }

  void guardDeleted() {
    if (isDeleted.get()) {
      throw new StorageRecordAlreadyDeletedException();
    }
  }
}
