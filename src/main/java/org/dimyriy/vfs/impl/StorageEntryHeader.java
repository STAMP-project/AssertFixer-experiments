package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.FilenameLengthTooLongException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.ByteUtil;

import javax.annotation.Nonnull;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.*;
import static org.dimyriy.vfs.impl.constants.StorageConstants.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
public class StorageEntryHeader {
  private static final byte[] RESERVED_SPACE = new byte[RESERVED_SPACE_LENGTH];
  @Nonnull
  private final byte[] filename;
  private final byte attribute;
  private int startingCluster;
  private int fileSize;
  private long modificationUnixTime;

  StorageEntryHeader(@Nonnull final byte[] filename,
                     final int startingCluster,
                     final int fileSize,
                     final long modificationUnixTime,
                     final byte attribute) {
    if (filename.length > StorageConstants.MAX_FILENAME_LENGTH_IN_BYTES) {
      throw new FilenameLengthTooLongException();
    }
    this.filename = new byte[StorageConstants.MAX_FILENAME_LENGTH_IN_BYTES];
    System.arraycopy(filename, 0, this.filename, 0, filename.length);
    this.startingCluster = startingCluster;
    this.fileSize = fileSize;
    this.modificationUnixTime = modificationUnixTime;
    this.attribute = attribute;
  }

  @Nonnull
  public byte[] getFilename() {
    return filename;
  }

  public long getModificationUnixTime() {
    return modificationUnixTime;
  }

  void setModificationUnixTime(final long modificationUnixTime) {
    this.modificationUnixTime = modificationUnixTime;
  }

  public final boolean isDirectory() {
    return attribute == DIRECTORY_ATTRIBUTE;
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

  byte getAttribute() {
    return attribute;
  }

  final boolean isFile() {
    return attribute == FILE_ATTRIBUTE;
  }

  byte[] toByteArray() {
    final byte[] result = new byte[length()];
    ByteUtil.writeByteAtOffset(result, ATTRIBUTE_OFFSET, attribute);
    ByteUtil.writeAtOffset(result, FILENAME_OFFSET, filename);
    ByteUtil.writeIntAtOffset(result, STARTING_CLUSTER_OFFSET, startingCluster);
    ByteUtil.writeIntAtOffset(result, FILESIZE_OFFSET, fileSize);
    ByteUtil.writeLongAtOffset(result, MODIFICATION_TIME_OFFSET, modificationUnixTime);
    ByteUtil.writeAtOffset(result, RESERVED_SPACE_OFFSET, RESERVED_SPACE);
    return result;
  }

  int numberOfChildStorageEntries() {
    Assertions.entryHeaderDirectory(this);
    return fileSize / CLUSTER_LENGTH_IN_BYTES;
  }

  StorageEntryHeader readEntryAtIndex(final int indexOfChildStorageEntryInDirectory, final StorageDataManager accessor) {
    Assertions.entryHeaderDirectory(this);
    return fromByteArray(accessor.readDataAtOffset(length(), startingCluster, directoryChildHeaderOffset(indexOfChildStorageEntryInDirectory)));
  }

  byte[] readFilenameOfEntry(final int indexOfChildStorageEntryInDirectory, final StorageDataManager accessor) {
    Assertions.entryHeaderDirectory(this);
    return accessor.readDataAtOffset(FILENAME_LENGTH, startingCluster, directoryChildFilenameOffset(indexOfChildStorageEntryInDirectory));
  }

  public static int length() {
    return STORAGE_ENTRY_HEADER_LENGTH;
  }

  static int calculateDirectorySizeInBytes(final int numberOfEntries) {
    return numberOfEntries * length();
  }

  static StorageEntryHeader fromByteArray(@Nonnull final byte[] fatEntry) {
    return fromByteArray(fatEntry, 0);
  }

  static StorageEntryHeader fromByteArray(@Nonnull final byte[] fatEntry, final int offset) {
    final byte attribute = ByteUtil.readByteAtOffset(fatEntry, offset + ATTRIBUTE_OFFSET);
    final byte[] filename = ByteUtil.readByteArrayAtOffset(fatEntry, offset + FILENAME_OFFSET, FILENAME_LENGTH_IN_CHARS);
    final int startingCluster = ByteUtil.readIntAtOffset(fatEntry, offset + STARTING_CLUSTER_OFFSET);
    final int fileSize = ByteUtil.readIntAtOffset(fatEntry, offset + FILESIZE_OFFSET);
    final long modificationUnixTime = ByteUtil.readLongAtOffset(fatEntry, offset + FILESIZE_OFFSET);
    return new StorageEntryHeader(filename, startingCluster, fileSize, modificationUnixTime, attribute);
  }

  private static int directoryChildHeaderOffset(final int indexOfElementInDirectory) {
    return (indexOfElementInDirectory * length());
  }

  private static int directoryChildFilenameOffset(final int indexOfElementInDirectory) {
    return directoryChildHeaderOffset(indexOfElementInDirectory) + FILENAME_OFFSET;
  }

  static final class RootDirectoryHeader extends StorageEntryHeader {
    RootDirectoryHeader(final int numberOfEntries, final long modificationUnixTime) {
      super(ByteUtil.asciiCharArrayToByteArray("root".toCharArray()),
            ROOT_DIRECTORY_STARTING_CLUSTER_INDEX,
            calculateDirectorySizeInBytes(numberOfEntries),
            modificationUnixTime,
            StorageConstants.DIRECTORY_ATTRIBUTE);
    }
  }

  static class EntryWithIndex {
    private final StorageEntryHeader storageEntryHeader;
    private final int index;

    EntryWithIndex(@Nonnull final StorageEntryHeader storageEntryHeader, final int index) {
      this.storageEntryHeader = storageEntryHeader;
      this.index = index;
    }

    StorageEntryHeader getStorageEntryHeader() {
      return storageEntryHeader;
    }

    int getIndex() {
      return index;
    }
  }
}
