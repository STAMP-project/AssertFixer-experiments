package org.dimyriy.vfs.impl.constants;

import org.dimyriy.vfs.impl.StorageEntryHeader;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("WeakerAccess")
public final class StorageConstants {
  public static final char SEPARATOR = '/';
  public static final String ROOT_DIRECTORY_UNIX_PATH = "/";
  public static final byte DIRECTORY_ATTRIBUTE = 0b0100_0000;
  public static final byte FILE_ATTRIBUTE = 0b0000_0000;
  public static final String FILENAME_ALLOWED_CHARACTERS_PATTERN = "^[A-Za-z\\-_]$";
  public static final String PATH_ALLOWED_CHARACTERS_PATTERN = "^/[A-Za-z\\-_/]$";
  public static final int NUMBER_OF_ALLOCATION_TABLES = 2;
  public static final int MAX_FILENAME_LENGTH_IN_BYTES = 11;
  public static final int CLUSTER_LENGTH_IN_BYTES = 4 * PlatformConstants.ONE_KILOBYTE;
  public static final int MAX_DIRECTORY_FILESIZE_IN_BYTES = CLUSTER_LENGTH_IN_BYTES;
  public static final int MAX_NUMBER_OF_ENTRIES_IN_DIRECTORY = CLUSTER_LENGTH_IN_BYTES / StorageEntryHeader.length();
  public static final int ROOT_DIRECTORY_SIZE_IN_BYTES = MAX_NUMBER_OF_ENTRIES_IN_DIRECTORY * CLUSTER_LENGTH_IN_BYTES;
  public static final int NUMBER_OF_ENTRIES_IN_EMPTY_DIRECTORY = 0;
  public static final int ROOT_DIRECTORY_STARTING_CLUSTER_INDEX = 0;
  public static final int FIRST_FAT_OFFSET_IN_BYTES = MetadataConstants.LENGTH;
  public static final int NUMBER_OF_CLUSTERS_TO_HOLD_DIRECTORY = 1;
  public static final int FILE_SYSTEM_MAX_NUMBER_OF_CLUSTERS = 8 * (PlatformConstants.ONE_GIGABYTE / CLUSTER_LENGTH_IN_BYTES);
  public static final int FILE_SYSTEM_MIN_NUMBER_OF_CLUSTERS = NUMBER_OF_CLUSTERS_TO_HOLD_DIRECTORY;

  private StorageConstants() {
  }

  public static PositiveLongRange primaryFileAllocationTableRange(final int numberOfClusters) {
    return new PositiveLongRange(FIRST_FAT_OFFSET_IN_BYTES, calculateSecondaryFatOffset(numberOfClusters));
  }

  public static PositiveLongRange secondaryFileAllocationTableRange(final int numberOfClusters) {
    final long secondaryFatOffset = calculateSecondaryFatOffset(numberOfClusters);
    return new PositiveLongRange(secondaryFatOffset, secondaryFatOffset + calculateFileAllocationTableSizeInBytes(numberOfClusters));
  }

  public static PositiveLongRange dataSectorRange(final int numberOfClusters) {
    return new PositiveLongRange(calculateDataSectorOffsetInBytes(numberOfClusters), calculateResultingFileSizeInBytes(numberOfClusters));
  }

  public static long calculateFileSystemSizeInBytes(final int numberOfClusters) {
    return CLUSTER_LENGTH_IN_BYTES * (long) numberOfClusters;
  }

  public static long calculateResultingFileSizeInBytes(final int numberOfClusters) {
    return calculateFileSystemSizeInBytes(numberOfClusters) + calculateDataSectorOffsetInBytes(numberOfClusters);
  }

  public static long calculateFileAllocationTableSizeInBytes(final int numberOfClusters) {
    return numberOfClusters * (long) Integer.BYTES;
  }

  public static long calculateDataSectorOffsetInBytes(final int numberOfClusters) {
    return FIRST_FAT_OFFSET_IN_BYTES + NUMBER_OF_ALLOCATION_TABLES * calculateFileAllocationTableSizeInBytes(numberOfClusters) + ROOT_DIRECTORY_SIZE_IN_BYTES;
  }

  public static int numberOfEntriesInEmptyDirectory() {
    return NUMBER_OF_ENTRIES_IN_EMPTY_DIRECTORY;
  }

  private static long calculateSecondaryFatOffset(final int numberOfClusters) {
    return FIRST_FAT_OFFSET_IN_BYTES + calculateFileAllocationTableSizeInBytes(numberOfClusters);
  }
}
