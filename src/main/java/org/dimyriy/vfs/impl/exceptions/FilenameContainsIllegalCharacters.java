package org.dimyriy.vfs.impl.exceptions;

import static org.dimyriy.vfs.impl.constants.StorageConstants.FILENAME_ALLOWED_CHARACTERS_PATTERN;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class FilenameContainsIllegalCharacters extends StorageException {
  public FilenameContainsIllegalCharacters() {
    super("Filename doesn't match pattern " + FILENAME_ALLOWED_CHARACTERS_PATTERN);
  }
}
