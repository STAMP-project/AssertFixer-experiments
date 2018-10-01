package org.dimyriy.vfs.impl.exceptions;

import org.dimyriy.vfs.impl.constants.StorageConstants;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public class FileSystemSizeGreaterThanAllowedMaximumException extends StorageException {
  public FileSystemSizeGreaterThanAllowedMaximumException() {
    super("Max allowed number of clusters is " + StorageConstants.FILE_SYSTEM_MAX_NUMBER_OF_CLUSTERS);
  }
}
