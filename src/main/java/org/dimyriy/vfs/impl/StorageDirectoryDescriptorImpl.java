package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectoryDescriptor;
import org.dimyriy.vfs.StorageFileDescriptor;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.impl.guards.Assertions;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
class StorageDirectoryDescriptorImpl extends AbstractStorageRecordDescriptorImpl implements StorageDirectoryDescriptor {
  StorageDirectoryDescriptorImpl(@Nonnull final StoragePath path, @Nonnull final StorageEntryHeader entryHeader, @Nonnull final InfileFileSystem owner) {
    super(path, entryHeader, owner);
  }

  @Override
  public StorageDirectoryDescriptor createChildDirectory(@Nonnull final String directoryName) {
    Assertions.filenameMatchesPattern(directoryName);
    guardClosed();
    guardDeleted();
    return getStorageFileSystem().createDirectory(new StoragePath(directoryName, getStorageFileSystem()));
  }

  @Override
  public StorageFileDescriptor createChildFile(@Nonnull final String filename) {
    Assertions.filenameMatchesPattern(filename);
    guardClosed();
    guardDeleted();
    return getStorageFileSystem().createFile(new StoragePath(filename, getStorageFileSystem()));
  }

  @Override
  public List<StoragePath> listChildren() {
    guardClosed();
    guardDeleted();
    return getStorageFileSystem().listChildren(this);
  }
}
