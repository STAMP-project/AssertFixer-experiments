package org.dimyriy.vfs.impl.constants;

import org.dimyriy.vfs.impl.misc.PositiveLongRange;

/**
 * @author Dmitrii Bogdanov
 * Created at 27.09.18
 */
@SuppressWarnings("WeakerAccess")
public final class MetadataConstants {
  public static final int FS_MARKER_MAGIC = 0x2b307a0e;
  public static final int UNLOCKED_MAGIC = 0xffffffff;
  public static final int OFFSET = 0;
  public static final int FS_MARKER_OFFSET = OFFSET;
  public static final int FS_MARKER_LENGTH = Integer.BYTES;
  public static final int LOCK_OFFSET = OFFSET + FS_MARKER_LENGTH;
  public static final int LOCK_LENGTH = PlatformConstants.PROCESS_ID_LENGTH_IN_BYTES;
  public static final int NUMBER_OF_CLUSTERS_OFFSET = LOCK_OFFSET + LOCK_LENGTH;
  public static final int NUMBER_OF_CLUSTERS_LENGTH = Integer.BYTES;
  public static final int CHECKSUM_OFFSET = NUMBER_OF_CLUSTERS_OFFSET + NUMBER_OF_CLUSTERS_LENGTH;
  public static final int CHECKSUM_LENGTH = Integer.BYTES;
  public static final int NUMBER_OF_ROOT_DIRECTORY_ENTRIES_OFFSET = CHECKSUM_OFFSET + CHECKSUM_LENGTH;
  public static final int NUMBER_OF_ROOT_DIRECTORY_ENTRIES_SIZE = Short.BYTES;
  public static final int ROOT_DIRECTORY_MODIFICATION_TS_OFFSET = NUMBER_OF_ROOT_DIRECTORY_ENTRIES_OFFSET + NUMBER_OF_ROOT_DIRECTORY_ENTRIES_SIZE;
  public static final int ROOT_DIRECTORY_MODIFICATION_TS_LENGTH_IN_BYTES = Long.BYTES;
  public static final int LENGTH = 32;
  public static final int CHECKSUM_MAGIC_PRIME = 585919;
  private static final PositiveLongRange METADATA_BYTE_RANGE = new PositiveLongRange(OFFSET, OFFSET + LENGTH);

  static {
    //noinspection ConstantConditions
    assert ROOT_DIRECTORY_MODIFICATION_TS_OFFSET + ROOT_DIRECTORY_MODIFICATION_TS_LENGTH_IN_BYTES <= LENGTH;
  }

  private MetadataConstants() {
  }

  public static PositiveLongRange metadataByteRange() {
    return METADATA_BYTE_RANGE;
  }
}
