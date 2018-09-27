package org.dimyriy.vfs.impl.exceptions;

import org.dimyriy.vfs.impl.constants.StorageConstants;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
public class FilenameLengthTooLongException extends StorageException {
  public FilenameLengthTooLongException() {
    super("Filename should not exceed " + StorageConstants.MAX_FILENAME_LENGTH_IN_BYTES + " ascii characters");
  }
}
