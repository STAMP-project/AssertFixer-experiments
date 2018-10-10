package org.dimyriy.vfs.impl.exceptions;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class PathContainsIllegalCharactersException extends StorageException {
  public PathContainsIllegalCharactersException() {
    super("Path contains double-slashes or non-ascii symbols");
  }
}
