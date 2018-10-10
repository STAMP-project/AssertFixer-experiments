package org.dimyriy.vfs.impl.exceptions;

import org.dimyriy.vfs.impl.util.ByteUtil;

/**
 * @author Dmitrii Bogdanov
 * Created at 27.09.18
 */
public class StorageEntryHeaderNotFoundException extends StorageException {
  public StorageEntryHeaderNotFoundException() {
  }

  public StorageEntryHeaderNotFoundException(final byte[] s) {
    this(ByteUtil.toAsciiString(s));
  }

  private StorageEntryHeaderNotFoundException(final String s) {
    super(s);
  }
}
