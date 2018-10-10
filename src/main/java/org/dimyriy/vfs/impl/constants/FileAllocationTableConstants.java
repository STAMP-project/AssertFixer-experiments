package org.dimyriy.vfs.impl.constants;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
@SuppressWarnings("WeakerAccess")
public final class FileAllocationTableConstants {
  public static final int ATTRIBUTE_OFFSET = 0;
  public static final int ATTRIBUTE_LENGTH = Byte.BYTES;
  public static final int FILENAME_OFFSET = ATTRIBUTE_OFFSET + ATTRIBUTE_LENGTH;
  public static final int FILENAME_LENGTH = StorageConstants.MAX_FILENAME_LENGTH_IN_BYTES * Byte.BYTES;
  public static final int FILENAME_LENGTH_IN_CHARS = FILENAME_LENGTH;
  public static final int STARTING_CLUSTER_OFFSET = FILENAME_OFFSET + FILENAME_LENGTH;
  public static final int STARTING_CLUSTER_LENGTH = Integer.BYTES;
  public static final int FILESIZE_OFFSET = STARTING_CLUSTER_OFFSET + STARTING_CLUSTER_LENGTH;
  public static final int FILESIZE_LENGTH = Integer.BYTES;
  public static final int MODIFICATION_TIME_OFFSET = FILESIZE_OFFSET + FILESIZE_LENGTH;
  public static final int MODIFICATION_TIME_LENGTH = Long.BYTES;
  public static final int PARENT_DIRECTORY_CLUSTER_NUMBER_OFFSET = MODIFICATION_TIME_OFFSET + MODIFICATION_TIME_LENGTH;
  public static final int PARENT_DIRECTORY_CLUSTER_NUMBER_LENGTH = Integer.BYTES;
  public static final int STORAGE_ENTRY_HEADER_LENGTH = PARENT_DIRECTORY_CLUSTER_NUMBER_OFFSET + PARENT_DIRECTORY_CLUSTER_NUMBER_LENGTH;
  public static final int EMPTY_CLUSTER = 0xFFFFFFFF;
  public static final int BAD_CLUSTER = 0xFFFFFFF8;
  public static final int FREE_CLUSTER = 0x00000000;

  static {
    //noinspection ConstantConditions
    assert STORAGE_ENTRY_HEADER_LENGTH <= 32;
  }

  private FileAllocationTableConstants() {
  }

  public static int filenameLength() {
    return FILENAME_LENGTH;
  }

  public static int badCluster() {
    return BAD_CLUSTER;
  }

  public static boolean isFreeCluster(final int clusterValue) {
    return clusterValue == FREE_CLUSTER;
  }

  public static boolean isEmptyCluster(final int clusterValue) {
    return clusterValue == emptyCluster();
  }

  public static int emptyCluster() {
    return EMPTY_CLUSTER;
  }

  public static boolean isBadCluster(final int clusterValue) {
    return clusterValue == BAD_CLUSTER;
  }

  public static int headerByteSize() {
    return STORAGE_ENTRY_HEADER_LENGTH;
  }
}
