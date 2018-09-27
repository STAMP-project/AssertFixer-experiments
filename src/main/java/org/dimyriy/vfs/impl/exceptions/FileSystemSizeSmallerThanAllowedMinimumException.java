package org.dimyriy.vfs.impl.exceptions;

import org.dimyriy.vfs.impl.constants.StorageConstants;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public class FileSystemSizeSmallerThanAllowedMinimumException extends StorageException {
  public FileSystemSizeSmallerThanAllowedMinimumException() {
    super("Min allowed number of clusters is " + StorageConstants.FILE_SYSTEM_MIN_NUMBER_OF_CLUSTERS);
  }
}
