package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.StorageRecordDescriptor;
import org.dimyriy.vfs.impl.exceptions.StorageEntryHeaderNotDirectoryException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyClosedException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyDeletedException;
import org.dimyriy.vfs.impl.util.ByteUtil;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public abstract class AbstractStorageRecordDescriptorImpl implements StorageRecordDescriptor {
  private final InfileFileSystem owner;
  private final AtomicBoolean isClosed = new AtomicBoolean(false);
  private final AtomicBoolean isDeleted = new AtomicBoolean(false);
  private final StorageEntryHeader header;
  private StoragePath path;

  AbstractStorageRecordDescriptorImpl(@Nonnull final StoragePath path, @Nonnull final StorageEntryHeader entryHeader, @Nonnull final InfileFileSystem owner) {
    this.owner = owner;
    this.path = path;
    this.header = entryHeader;
    this.owner.notifyCreated(this);
  }

  @Override
  public long getModificationUnixTime() {
    return header.getModificationUnixTime();
  }

  @Override
  public StorageEntryHeader header() {
    return header;
  }

  @Override
  public InfileFileSystem fs() {
    return this.owner;
  }

  @Override
  public StoragePath getPath() {
    return path;
  }

  @Override
  public void delete() {
    guardClosed();
    guardDeleted();
    fs().inWriteContext(() -> {
      guardClosed();
      guardDeleted();
      final StorageDirectoryEntryHeader parent = findParentDescriptor();
      parent.deleteChild(this.header());
      fs().notifyDeleted(this);
      setDeletedFlag();
    });
  }

  @Override
  public boolean isClosed() {
    return isClosed.get();
  }

  @Override
  public void close() {
    guardClosed();
    this.isClosed.set(true);
    owner.notifyClosed(this);
  }

  @Override
  public String getFilename() {
    return ByteUtil.toAsciiString(header.getFilename());
  }

  void guardNotClosedNotDeleted() {
    guardClosed();
    guardDeleted();
  }

  StorageDataManager dataManager() {
    return fs().dataManager();
  }

  private StorageDirectoryEntryHeader findParentDescriptor() {
    final StoragePath parent = getPath().parent();
    final StorageEntryHeader entryHeader = fs().descriptorsCache().computeIfAbsent(parent, s -> fs().open(s)).header();
    if (!(entryHeader instanceof StorageDirectoryEntryHeader)) {
      throw new StorageEntryHeaderNotDirectoryException();
    }
    return (StorageDirectoryEntryHeader) entryHeader;
  }

  void updatePath(@Nonnull final StoragePath path) {
    this.path = path;
  }

  private void setDeletedFlag() {
    this.isDeleted.set(true);
  }

  void guardDeleted() {
    if (isDeleted.get()) {
      throw new StorageRecordAlreadyDeletedException();
    }
  }

  void guardClosed() {
    if (isClosed.get()) {
      throw new StorageRecordAlreadyClosedException();
    }
  }
}
