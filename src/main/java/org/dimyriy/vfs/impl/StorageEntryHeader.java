package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.FilenameLengthTooLongException;
import org.dimyriy.vfs.impl.exceptions.StorageEntryHeaderNotFoundException;
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
  private StorageDataManager dataManager = null;

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

  public final boolean isDirectory() {
    return attribute == DIRECTORY_ATTRIBUTE;
  }

  @Nonnull
  public byte[] getFilename() {
    return filename;
  }

  public void setFilename(@Nonnull final byte[] filename) {
    LOGGER.trace("Setting filename {}", filename);
    this.filename = filename;
  }

  void setDataManager(@Nonnull final StorageDataManager dataManager) {
    this.dataManager = dataManager;
  }

  int getFileSize() {
    return fileSize;
  }

  void setFileSize(final int fileSize) {
    LOGGER.trace("Setting filesize {}", fileSize);
    this.fileSize = fileSize;
  }

  boolean isEmpty() {
    return isEmptyCluster(startingCluster) && fileSize == 0;
  }

  int getStartingCluster() {
    return startingCluster;
  }

  void setStartingCluster(final int startingCluster) {
    LOGGER.trace("Setting starting cluster {}", startingCluster);
    this.startingCluster = startingCluster;
  }

  byte[] toByteArray() {
    LOGGER.trace("Converting to byte array {} started", this);
    final byte[] result = new byte[sizeInBytes()];
    ByteUtil.writeByteAtOffset(result, ATTRIBUTE_OFFSET, attribute);
    ByteUtil.writeAtOffset(result, FILENAME_OFFSET, filename);
    ByteUtil.writeIntAtOffset(result, STARTING_CLUSTER_OFFSET, startingCluster);
    ByteUtil.writeIntAtOffset(result, FILESIZE_OFFSET, fileSize);
    ByteUtil.writeLongAtOffset(result, MODIFICATION_TIME_OFFSET, modificationUnixTime);
    ByteUtil.writeIntAtOffset(result, PARENT_DIRECTORY_CLUSTER_NUMBER_OFFSET, parentDirectoryCluster);
    LOGGER.trace("Converting to byte array {} finished. Result: {}", this, result);
    return result;
  }

  void rewrite(@Nonnull final byte[] filename) {
    LOGGER.trace("Rewriting header {} started. Old header {}", filename, this);
    setModificationUnixTime(SystemUtil.currentTS());
    final byte[] bytes = toByteArray();
    final int index = findEntryIndexInParent(filename);
    if (index == nullEntryIndex()) {
      throw new StorageEntryHeaderNotFoundException();
    }
    dataManager.writeContent(bytes, new StorageDataManager.OffsetRwState(parentDirectoryCluster, bytes.length,
                                                                         offsetByIndex(index)));
    LOGGER.trace("Rewriting header {} finished. New header {}", filename, this);
  }

  long getModificationUnixTime() {
    return modificationUnixTime;
  }

  void setModificationUnixTime(final long modificationUnixTime) {
    LOGGER.trace("Setting modification time {}", modificationUnixTime);
    this.modificationUnixTime = modificationUnixTime;
  }

  final boolean isFile() {
    return isFileAttribute(attribute);
  }

  void rename(@Nonnull final byte[] newName) {
    LOGGER.trace("Renaming header. OldName: {}. NewName: {}", getFilename(), newName);
    final byte[] oldFilename = filename;
    setFilename(newName);
    rewrite(oldFilename);
  }

  boolean siblingExists(@Nonnull final byte[] filename) {
    return findEntryIndexInParent(filename) != nullEntryIndex();
  }

  int findEntryIndexByFilenameAndClusterNumberUnbound(@Nonnull final byte[] filename,
                                                      final int clusterNumber,
                                                      final int nEntries) {
    LOGGER.trace("Searching for entry with filename {} started", filename);
    for (int i = 0; i < nEntries; i++) {
      if (Arrays.equals(readFilenameByClusterNumberAndIndex(clusterNumber, i), filename)) {
        LOGGER.trace("Searching for entry with filename {} finished. Entry index: {}", filename, i);
        return i;
      }
    }
    LOGGER.trace("Searching for entry with filename {} finished. Entry not found", filename);
    return nullEntryIndex();
  }

  byte[] readFilenameByClusterNumberAndIndex(final int clusterNumber, final int index) {
    return dataManager().readContent(new StorageDataManager.OffsetRwState(clusterNumber, filenameLength(), directoryChildFilenameOffset(index)));
  }

  StorageDataManager dataManager() {
    return dataManager;
  }

  void freeOccupiedClusters() {
    LOGGER.trace("Freeing of occupied clusters started");
    int nextCluster = startingCluster;
    while (!isEmptyCluster(nextCluster)) {
      nextCluster = dataManager.freeCluster(nextCluster);
    }
    LOGGER.trace("Freeing of occupied clusters finished");
  }

  private int findEntryIndexInParent(@Nonnull final byte[] filename) {
    return findEntryIndexByFilenameAndClusterNumberUnbound(filename, this.parentDirectoryCluster, maxNumberOfDirectoryEntries());
  }

  public static int sizeInBytes() {
    return headerByteSize();
  }

  static int nullEntryIndex() {
    return -1;
  }

  static int offsetByIndex(final int index) {
    return (index * sizeInBytes());
  }

  static StorageEntryHeader fromByteArray(@Nonnull final byte[] headerContent) {
    return fromByteArray(headerContent, 0);
  }

  static StorageEntryHeader fromByteArray(@Nonnull final byte[] headerContent, final int offset) {
    LOGGER.trace("Creation of entry from byte array started. Array {}", headerContent);
    final byte attribute = ByteUtil.readByteAtOffset(headerContent, offset + ATTRIBUTE_OFFSET);
    final byte[] filename = ByteUtil.readByteArrayAtOffset(headerContent, offset + FILENAME_OFFSET, FILENAME_LENGTH_IN_CHARS);
    final int startingCluster = ByteUtil.readIntAtOffset(headerContent, offset + STARTING_CLUSTER_OFFSET);
    final int fileSize = ByteUtil.readIntAtOffset(headerContent, offset + FILESIZE_OFFSET);
    final long modificationUnixTime = ByteUtil.readLongAtOffset(headerContent, offset + FILESIZE_OFFSET);
    final int parentCluster = ByteUtil.readIntAtOffset(headerContent, offset + PARENT_DIRECTORY_CLUSTER_NUMBER_OFFSET);
    final StorageEntryHeader entryHeader = create(attribute, filename, startingCluster, fileSize, modificationUnixTime, parentCluster);
    LOGGER.trace("Creation of entry from byte array finished. Entry {}", entryHeader);
    return entryHeader;
  }

  static StorageEntryHeader create(final byte attribute,
                                   final byte[] filename,
                                   final int startingCluster,
                                   final int fileSize,
                                   final long modificationUnixTime,
                                   final int parentCluster) {
    if (attribute == directoryAttribute()) {
      return new StorageDirectoryEntryHeader(filename, startingCluster, fileSize, modificationUnixTime, parentCluster);
    } else {
      return new StorageFileEntryHeader(filename, startingCluster, fileSize, modificationUnixTime, parentCluster);
    }
  }

  static int directoryByteSize(final int numberOfEntries) {
    return numberOfEntries * sizeInBytes();
  }

  static void guardEntryIndex(final int index) {
    if (index == nullEntryIndex()) {
      throw new StorageEntryHeaderNotFoundException();
    }
  }

  private static int directoryChildFilenameOffset(final int indexOfElementInDirectory) {
    return offsetByIndex(indexOfElementInDirectory) + FILENAME_OFFSET;
  }
}
