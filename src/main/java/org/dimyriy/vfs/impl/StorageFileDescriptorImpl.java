package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageFileDescriptor;
import org.dimyriy.vfs.StoragePath;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
class StorageFileDescriptorImpl extends AbstractStorageRecordDescriptorImpl implements StorageFileDescriptor {
  StorageFileDescriptorImpl(@Nonnull final StoragePath storagePath,
                            @Nonnull final StorageEntryHeader entryHeader,
                            @Nonnull final InfileFileSystem owner) {
    super(storagePath, entryHeader, owner);
  }

  @Override
  public byte[] readContent() {
    guardClosed();
    guardDeleted();
    return getStorageFileSystem().readFileContent(this);
  }

  @Override
  public void writeContent(@Nonnull final byte[] content) {
    guardClosed();
    guardDeleted();
    getStorageFileSystem().writeFileContent(this, content);
  }
}
