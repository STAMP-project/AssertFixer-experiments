package org.dimyriy.vfs.impl.exceptions;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public class FilenameContainsIllegalCharacters extends StorageException {
  public FilenameContainsIllegalCharacters() {
    super("Filename contains slashes or non-ascii symbols");
  }
}
