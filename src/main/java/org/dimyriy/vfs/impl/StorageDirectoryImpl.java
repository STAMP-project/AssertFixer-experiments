package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectory;
import org.dimyriy.vfs.StorageFile;
import org.dimyriy.vfs.StorageFileSystem;
import org.dimyriy.vfs.impl.exceptions.*;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
abstract class StorageDirectoryImpl extends AbstractStorageRecordImpl implements StorageDirectory {
  StorageDirectoryImpl(@Nonnull final StorageDirectory parent, @Nonnull final String name, @Nonnull final StorageFileSystem owner) {
    super(parent, name, owner);
  }

  @Override
  public StorageDirectory createDirectory(@Nonnull final String directoryName) {
    return getStorageFileSystem().createDirectory(this.getPath().child(directoryName));
  }

  @Override
  public StorageFile createFile(@Nonnull final String filename) {
    return getStorageFileSystem().createFile(this.getPath().child(filename));
  }

  static final class RootDirectory extends StorageDirectoryImpl {

    public RootDirectory(@Nonnull final StorageDirectory parent, @Nonnull final String name, @Nonnull final StorageFileSystem owner) {
      super(parent, name, owner);
    }

    @Override
    public String getFilename() {
      return "root";
    }

    @Override
    public StorageDirectory getParent() {
      return null;
    }

    @Override
    public void create() throws StorageRecordAlreadyExistsException {
      throw new StorageRecordAlreadyExistsException();
    }

    @Override
    public void delete() throws StorageRecordDoesNotExistException, StorageDirectoryNotEmptyException {
      throw new RootDirectoryCannotBeChangedException();
    }

    @Override
    public void rename(@Nonnull final String newName) throws StorageRecordAlreadyExistsException, StorageRecordAlreadyDeletedException {
      throw new RootDirectoryCannotBeChangedException();
    }
  }
}
