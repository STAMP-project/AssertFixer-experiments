package org.dimyriy.vfs.impl.exceptions;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
public class FileSystemLockedByAnotherProcessException extends StorageException {
  private final int pid;

  public FileSystemLockedByAnotherProcessException(final int pid) {
    this.pid = pid;
  }

  public int getPid() {
    return pid;
  }
}
