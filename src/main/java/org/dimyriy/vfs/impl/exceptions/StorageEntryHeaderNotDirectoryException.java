package org.dimyriy.vfs.impl.exceptions;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class StorageEntryHeaderNotDirectoryException extends StorageException {
  public StorageEntryHeaderNotDirectoryException() {
  }

  public StorageEntryHeaderNotDirectoryException(@Nonnull final String s) {
    super(s);
  }
}
