package org.dimyriy.vfs.impl.constants;

import org.dimyriy.vfs.impl.StorageEntryHeader;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
public final class StorageConstants {
  public static final char SEPARATOR = '/';
  public static final String ROOT_DIRECTORY_UNIX_PATH = "/";
  public static final byte DIRECTORY_ATTRIBUTE = 0b0100_0000;
  public static final String DOUBLE_SLASHES_PATTERN = "^(/)?([^/]+(/)?)+$";
  public static final int MAX_FILENAME_LENGTH_IN_BYTES = 11;
  private static final int DEFAULT_CLUSTER_SIZE_IN_BYTES = 4 * PlatformConstants.ONE_KILOBYTE;
  public static final int FILE_SYSTEM_MAX_NUMBER_OF_CLUSTERS = 8 * (PlatformConstants.ONE_GIGABYTE / DEFAULT_CLUSTER_SIZE_IN_BYTES);
  private static final int MAX_DIRECTORY_FILESIZE_IN_BYTES = DEFAULT_CLUSTER_SIZE_IN_BYTES;
  private static final byte FILE_ATTRIBUTE = 0b0000_0000;
  private static final String ROOT_DIRECTORY_NAME = "";
  private static final int ROOT_DIRECTORY_STARTING_CLUSTER_INDEX = 0;
  private static final short NUMBER_OF_ENTRIES_IN_EMPTY_DIRECTORY = 0;
  private static final int NUMBER_OF_CLUSTERS_TO_HOLD_DIRECTORY = 1;
  public static final int FILE_SYSTEM_MIN_NUMBER_OF_CLUSTERS = NUMBER_OF_CLUSTERS_TO_HOLD_DIRECTORY;
  private static final int MAX_NUMBER_OF_HEADERS_IN_CLUSTER = DEFAULT_CLUSTER_SIZE_IN_BYTES / StorageEntryHeader.sizeInBytes();
  private static final int MAX_NUMBER_OF_ENTRIES_IN_DIRECTORY = MAX_NUMBER_OF_HEADERS_IN_CLUSTER;
  private static final int ROOT_DIRECTORY_SIZE_IN_BYTES = MAX_NUMBER_OF_ENTRIES_IN_DIRECTORY * DEFAULT_CLUSTER_SIZE_IN_BYTES;
  private static final int FIRST_FAT_OFFSET_IN_BYTES = MetadataConstants.LENGTH;
  private static final int DEFAULT_REPAIR_BAD_CLUSTERS_PERIOD_IN_SECONDS = 60;
  private static final int DEFAULT_PATHS_CACHE_SIZE = 65535;
  private static final int DEFAULT_DATA_READERS_POOL_SIZE = 5;
  private static final int DEFAULT_METADATA_READERS_POOL_SIZE = 1;
  private static final int MAX_NESTED_DIRECTORY_LEVEL = 65535;
  private static final int MAX_NUMBER_OF_OPEN_DESCRIPTORS = 65535;
  private static final int NUMBER_OF_ALLOCATION_TABLES = 2;

  private StorageConstants() {
  }

  public static int getMaxDirectoryFilesizeInBytes() {
    return MAX_DIRECTORY_FILESIZE_IN_BYTES;
  }

  public static byte fileAttribute() {
    return FILE_ATTRIBUTE;
  }

  public static boolean isFileAttribute(final byte attribute) {
    return attribute == fileAttribute();
  }

  public static PositiveLongRange firstFileAllocationTableRange(final int numberOfClusters) {
    return new PositiveLongRange(FIRST_FAT_OFFSET_IN_BYTES, calculateSecondFatOffset(numberOfClusters));
  }

  public static PositiveLongRange secondFileAllocationTableRange(final int numberOfClusters) {
    final long secondFatOffset = calculateSecondFatOffset(numberOfClusters);
    return new PositiveLongRange(secondFatOffset, secondFatOffset + calculateFileAllocationTableSizeInBytes(numberOfClusters));
  }

  public static PositiveLongRange dataSectorRange(final int numberOfClusters, final int clusterSize) {
    final long dataSectorOffset = calculateDataSectorOffsetInBytes(numberOfClusters);
    return new PositiveLongRange(dataSectorOffset, dataSectorOffset + numberOfClusters * clusterSize);
  }

  public static short numberOfEntriesInEmptyDirectory() {
    return NUMBER_OF_ENTRIES_IN_EMPTY_DIRECTORY;
  }

  public static int maxNumberOfDirectoryEntries() {
    return MAX_NUMBER_OF_ENTRIES_IN_DIRECTORY;
  }

  public static int maxNestedDirectoryLevel() {
    return MAX_NESTED_DIRECTORY_LEVEL;
  }

  public static int getMaxNumberOfOpenDescriptors() {
    return MAX_NUMBER_OF_OPEN_DESCRIPTORS;
  }

  public static int getDefaultDataReadersPoolSize() {
    return DEFAULT_DATA_READERS_POOL_SIZE;
  }

  public static int getDefaultMetadataReadersPoolSize() {
    return DEFAULT_METADATA_READERS_POOL_SIZE;
  }

  public static int getDefaultPathsCacheSize() {
    return DEFAULT_PATHS_CACHE_SIZE;
  }

  public static int getDefaultRepairBadClustersPeriodInSeconds() {
    return DEFAULT_REPAIR_BAD_CLUSTERS_PERIOD_IN_SECONDS;
  }

  public static int getDefaultClusterSizeInBytes() {
    return DEFAULT_CLUSTER_SIZE_IN_BYTES;
  }

  public static int getFileSystemMaxNumberOfClusters() {
    return FILE_SYSTEM_MAX_NUMBER_OF_CLUSTERS;
  }

  public static int getFileSystemMinNumberOfClusters() {
    return FILE_SYSTEM_MIN_NUMBER_OF_CLUSTERS;
  }

  public static byte directoryAttribute() {
    return DIRECTORY_ATTRIBUTE;
  }

  public static String getRootDirectoryName() {
    return ROOT_DIRECTORY_NAME;
  }

  public static int getRootDirectoryStartingClusterIndex() {
    return ROOT_DIRECTORY_STARTING_CLUSTER_INDEX;
  }

  public static int getMaxFilenameLengthInBytes() {
    return MAX_FILENAME_LENGTH_IN_BYTES;
  }

  private static long calculateFileAllocationTableSizeInBytes(final int numberOfClusters) {
    return numberOfClusters * ((long) Integer.BYTES);
  }

  private static long calculateDataSectorOffsetInBytes(final int numberOfClusters) {
    return FIRST_FAT_OFFSET_IN_BYTES + NUMBER_OF_ALLOCATION_TABLES * calculateFileAllocationTableSizeInBytes(numberOfClusters) + ROOT_DIRECTORY_SIZE_IN_BYTES;
  }

  private static long calculateSecondFatOffset(final int numberOfClusters) {
    return FIRST_FAT_OFFSET_IN_BYTES + calculateFileAllocationTableSizeInBytes(numberOfClusters);
  }
}
