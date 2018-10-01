package org.dimyriy.vfs.impl.exceptions;

/**
 * @author Dmitrii Bogdanov
 * Created at 27.09.18
 */
public class StorageEntryHeaderNotFoundException extends StorageException {
  public StorageEntryHeaderNotFoundException() {
  }

  public StorageEntryHeaderNotFoundException(final String s) {
    super(s);
  }
}
