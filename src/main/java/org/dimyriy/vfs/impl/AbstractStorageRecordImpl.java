package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectory;
import org.dimyriy.vfs.StorageFileSystem;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.StorageRecord;
import org.dimyriy.vfs.impl.constants.StorageConstants;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public abstract class AbstractStorageRecordImpl implements StorageRecord {
  protected final String name;
  protected final StoragePath storagePath;
  protected final StorageDirectory parent;
  protected final StorageFileSystem owner;
  protected final AtomicBoolean isDeleted = new AtomicBoolean(false);
  protected final AtomicBoolean isCreatedOnDisk = new AtomicBoolean(false);

  public AbstractStorageRecordImpl(@Nonnull final StorageDirectory parent, @Nonnull final String name, @Nonnull final StorageFileSystem owner) {
    this.name = name;
    this.parent = parent;
    this.owner = owner;
    this.storagePath = parent.getPath().child(name);
  }

  @Override
  public StorageFileSystem getStorageFileSystem() {
    return this.owner;
  }

  @Override
  public boolean isDeleted() {
    return isDeleted.get();
  }

  @Override
  public StoragePath getPath() {
    return storagePath;
  }

  byte getAttribute() {
    return isDirectory() ? StorageConstants.DIRECTORY_ATTRIBUTE : StorageConstants.FILE_ATTRIBUTE;
  }
}
