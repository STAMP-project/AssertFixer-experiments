package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.FilenameLengthTooLongException;
import org.dimyriy.vfs.impl.exceptions.StorageEntryHeaderNotFoundException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Arrays;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.*;
import static org.dimyriy.vfs.impl.constants.StorageConstants.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
public class StorageEntryHeader {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageEntryHeader.class);
  private final byte attribute;
  private final int parentDirectoryCluster;
  @Nonnull
  private byte[] filename;
  private int startingCluster;
  private int fileSize;
  private long modificationUnixTime;

  StorageEntryHeader(final byte attribute,
                     @Nonnull final byte[] filename,
                     final int startingCluster,
                     final int fileSize,
                     final long modificationUnixTime,
                     final int parentDirectoryCluster) {
    this.attribute = attribute;
    if (filename.length > StorageConstants.getMaxFilenameLengthInBytes()) {
      throw new FilenameLengthTooLongException();
    }
    this.filename = new byte[StorageConstants.getMaxFilenameLengthInBytes()];
    System.arraycopy(filename, 0, this.filename, 0, filename.length);
    this.startingCluster = startingCluster;
    this.fileSize = fileSize;
    this.modificationUnixTime = modificationUnixTime;
    this.parentDirectoryCluster = parentDirectoryCluster;
  }

  @Nonnull
  public byte[] getFilename() {
    return filename;
  }

  public void setFilename(@Nonnull final byte[] filename) {
    this.filename = filename;
  }

  public final boolean isDirectory() {
    return attribute == DIRECTORY_ATTRIBUTE;
  }

  long getModificationUnixTime() {
    return modificationUnixTime;
  }

  void setModificationUnixTime(final long modificationUnixTime) {
    this.modificationUnixTime = modificationUnixTime;
  }

  int getStartingCluster() {
    return startingCluster;
  }

  void setStartingCluster(final int startingCluster) {
    this.startingCluster = startingCluster;
  }

  int getFileSize() {
    return fileSize;
  }

  void setFileSize(final int fileSize) {
    this.fileSize = fileSize;
  }

  final boolean isFile() {
    return isFileAttribute(attribute);
  }

  byte[] toByteArray() {
    final byte[] result = new byte[sizeInBytes()];
    ByteUtil.writeByteAtOffset(result, ATTRIBUTE_OFFSET, attribute);
    ByteUtil.writeAtOffset(result, FILENAME_OFFSET, filename);
    ByteUtil.writeIntAtOffset(result, STARTING_CLUSTER_OFFSET, startingCluster);
    ByteUtil.writeIntAtOffset(result, FILESIZE_OFFSET, fileSize);
    ByteUtil.writeLongAtOffset(result, MODIFICATION_TIME_OFFSET, modificationUnixTime);
    ByteUtil.writeIntAtOffset(result, PARENT_DIRECTORY_CLUSTER_NUMBER_OFFSET, parentDirectoryCluster);
    return result;
  }

  void rewrite(@Nonnull final byte[] filename, @Nonnull final StorageDataManager accessor) {
    setModificationUnixTime(SystemUtil.currentTS());
    final byte[] bytes = toByteArray();
    accessor.appendContent(bytes, new StorageDataManager.OffsetRwState(bytes.length,
                                                                       parentDirectoryCluster,
                                                                       offsetByIndex(locateInParent(filename, accessor))));
  }

  StorageEntryHeader getChild(@Nonnull final byte[] filename, @Nonnull final StorageDataManager accessor) {
    return readChildHeaderAtIndex(locateChildByFilenameSafely(filename, accessor), accessor);
  }

  boolean childExists(@Nonnull final byte[] filename, @Nonnull final StorageDataManager accessor) {
    if (fileSize == 0) {
      return false;
    }
    try {
      final int i = locateChildByFilenameSafely(filename, accessor);
      LOGGER.trace("Child exists for filename {} with index {}", filename, i);
      return true;
    } catch (final StorageEntryHeaderNotFoundException e) {
      return false;
    }
  }

  int locateChildByFilenameSafely(@Nonnull final byte[] filename, @Nonnull final StorageDataManager accessor) {
    assertDirectory();
    if (isEmpty()) {
      throw new StorageEntryHeaderNotFoundException();
    }
    return locateHeaderByClusterNumberAndFilenameSafely(filename, startingCluster, accessor);
  }

  int numberOfChildStorageEntries() {
    assertDirectory();
    return fileSize / sizeInBytes();
  }

  boolean isEmpty() {
    return isEmptyCluster(startingCluster) && fileSize == 0;
  }

  private int locateHeaderByClusterNumberAndFilenameSafely(@Nonnull final byte[] filename, final int startingCluster, final StorageDataManager accessor) {
    return locateHeaderByClusterNumberAndFilename(filename, startingCluster, numberOfChildStorageEntries(), accessor);
  }

  private StorageEntryHeader readChildHeaderAtIndex(final int index, @Nonnull final StorageDataManager accessor) {
    assertDirectory();
    if (isEmpty()) {
      throw new StorageEntryHeaderNotFoundException();
    }
    return readHeaderByClusterNumberAndIndex(this.startingCluster, index, accessor);
  }

  private void assertDirectory() {
    Assertions.entryHeaderIsDirectory(this);
  }

  private int locateInParent(@Nonnull final byte[] oldFilename, @Nonnull final StorageDataManager accessor) {
    return locateInParentByFilename(oldFilename, accessor);
  }

  private int locateInParentByFilename(@Nonnull final byte[] filename, @Nonnull final StorageDataManager accessor) {
    return locateHeaderByClusterNumberAndFilename(filename, this.parentDirectoryCluster, maxNumberOfDirectoryEntries(), accessor);
  }

  private int locateHeaderByClusterNumberAndFilename(@Nonnull final byte[] filename,
                                                     final int clusterNumber,
                                                     final int nEntries,
                                                     @Nonnull final StorageDataManager accessor) {
    for (int i = 0; i < nEntries; i++) {
      if (Arrays.equals(readFilenameByClusterNumberAndIndex(clusterNumber, i, accessor), filename)) {
        return i;
      }
    }
    throw new StorageEntryHeaderNotFoundException();
  }

  private byte[] readFilenameByClusterNumberAndIndex(final int clusterNumber, final int index, @Nonnull final StorageDataManager accessor) {
    return accessor.readData(new StorageDataManager.OffsetRwState(filenameLength(), clusterNumber, directoryChildFilenameOffset(index)), false);
  }

  private StorageEntryHeader readHeaderByClusterNumberAndIndex(final int clusterNumber, final int index, @Nonnull final StorageDataManager accessor) {
    return fromByteArray(accessor.readData(new StorageDataManager.OffsetRwState(sizeInBytes(), clusterNumber, offsetByIndex(index)), false));
  }

  public static int sizeInBytes() {
    return headerByteSize();
  }

  static StorageEntryHeader fromByteArray(@Nonnull final byte[] headerContent) {
    return fromByteArray(headerContent, 0);
  }

  static StorageEntryHeader fromByteArray(@Nonnull final byte[] headerContent, final int offset) {
    final byte attribute = ByteUtil.readByteAtOffset(headerContent, offset + ATTRIBUTE_OFFSET);
    final byte[] filename = ByteUtil.readByteArrayAtOffset(headerContent, offset + FILENAME_OFFSET, FILENAME_LENGTH_IN_CHARS);
    final int startingCluster = ByteUtil.readIntAtOffset(headerContent, offset + STARTING_CLUSTER_OFFSET);
    final int fileSize = ByteUtil.readIntAtOffset(headerContent, offset + FILESIZE_OFFSET);
    final long modificationUnixTime = ByteUtil.readLongAtOffset(headerContent, offset + FILESIZE_OFFSET);
    final int parentCluster = ByteUtil.readIntAtOffset(headerContent, offset + PARENT_DIRECTORY_CLUSTER_NUMBER_OFFSET);
    return new StorageEntryHeader(attribute, filename, startingCluster, fileSize, modificationUnixTime, parentCluster);
  }

  static int directoryByteSize(final int numberOfEntries) {
    return numberOfEntries * sizeInBytes();
  }

  private static int offsetByIndex(final int index) {
    return (index * sizeInBytes());
  }

  private static int directoryChildFilenameOffset(final int indexOfElementInDirectory) {
    return offsetByIndex(indexOfElementInDirectory) + FILENAME_OFFSET;
  }

  static final class RootDirectoryHeader extends StorageEntryHeader {
    RootDirectoryHeader(final int numberOfEntries, final long modificationUnixTime) {
      super(
        directoryAttribute(),
        ByteUtil.asciiCharArrayToByteArray(getRootDirectoryName().toCharArray()),
        getRootDirectoryStartingClusterIndex(),
        directoryByteSize(numberOfEntries),
        modificationUnixTime,
        emptyCluster());
    }

    @Override
    void rewrite(@Nonnull final byte[] filename, @Nonnull final StorageDataManager accessor) {
      accessor.updateRootDirectoryHeader();
    }
  }
}
