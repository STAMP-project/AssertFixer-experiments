package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.*;
import org.dimyriy.vfs.impl.exceptions.StorageRecordDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public class InfileFileSystem implements StorageFileSystem {
  private static final Logger LOGGER = LoggerFactory.getLogger(InfileFileSystem.class);
  private final Storage storage;

  InfileFileSystem(@Nonnull final Storage storage) {
    this.storage = storage;
  }

  public String getAbsoluteFullPathOfStorageFile() {
    return storage.getAbsoluteFullPathOfStorageFile();
  }

  public StorageDirectoryImpl getRootDirectory() {
    throw new NotImplementedException();
  }

  @Override
  public void close() {
    storage.close();
  }

  @Override
  public StorageDirectory createDirectory(final StoragePath path) {
    throw new NotImplementedException();
  }

  @Override
  public StorageFile createFile(final StoragePath path) {
    throw new NotImplementedException();
  }

  @Override
  public StorageRecord find(final StoragePath path) throws StorageRecordDoesNotExistException {
    throw new NotImplementedException();
  }
}
