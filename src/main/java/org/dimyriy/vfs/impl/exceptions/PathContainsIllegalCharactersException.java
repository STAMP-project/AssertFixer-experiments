package org.dimyriy.vfs.impl.exceptions;

import static org.dimyriy.vfs.impl.constants.StorageConstants.PATH_ALLOWED_CHARACTERS_PATTERN;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class PathContainsIllegalCharactersException extends StorageException {
  public PathContainsIllegalCharactersException() {
    super("Path doesn't match pattern " + PATH_ALLOWED_CHARACTERS_PATTERN);
  }
}
