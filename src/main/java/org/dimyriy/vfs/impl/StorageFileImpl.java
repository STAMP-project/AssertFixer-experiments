package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectory;
import org.dimyriy.vfs.StorageFile;
import org.dimyriy.vfs.StorageFileSystem;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public abstract class StorageFileImpl extends AbstractStorageRecordImpl implements StorageFile {
  public StorageFileImpl(@Nonnull final StorageDirectory parent,
                         @Nonnull final String name,
                         @Nonnull final StorageFileSystem owner) {
    super(parent, name, owner);
  }
}
