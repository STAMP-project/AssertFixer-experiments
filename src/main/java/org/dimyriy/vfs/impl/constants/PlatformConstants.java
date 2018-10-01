package org.dimyriy.vfs.impl.constants;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("WeakerAccess")
public final class PlatformConstants {
  public static final String RANDOM_ACCESS_FILE_READ_MODE = "r";
  static final int ONE_BYTE = 1;
  static final int HALF_KILOBYTE = 512 * ONE_BYTE;
  static final int ONE_KILOBYTE = 1024 * ONE_BYTE;
  public static final int ONE_MEGABYTE = 1024 * ONE_KILOBYTE;
  static final int ONE_GIGABYTE = 1024 * ONE_MEGABYTE;
  static final int PROCESS_ID_LENGTH_IN_BYTES = Integer.BYTES;
  private static final String RANDOM_ACCESS_FILE_WRITE_MODE = "w";
  public static final String RANDOM_ACCESS_FILE_READ_WRITE_MODE = RANDOM_ACCESS_FILE_READ_MODE + RANDOM_ACCESS_FILE_WRITE_MODE;

  private PlatformConstants() {
  }
}
