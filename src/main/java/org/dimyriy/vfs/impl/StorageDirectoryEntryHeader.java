package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StorageEntryHeaderNotFoundException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.SystemUtil;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.emptyCluster;
import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.headerByteSize;
import static org.dimyriy.vfs.impl.constants.StorageConstants.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 03.10.18
 */
class StorageDirectoryEntryHeader extends StorageEntryHeader {
  StorageDirectoryEntryHeader(
    @Nonnull final byte[] filename,
    final int startingCluster,
    final int fileSize,
    final long modificationUnixTime,
    final int parentDirectoryCluster) {
    super(StorageConstants.directoryAttribute(), filename, startingCluster, fileSize, modificationUnixTime, parentDirectoryCluster);
  }


  StorageEntryHeader createEmptyChild(final byte[] childFilename, final boolean isDirectory) {
    Assertions.directorySizeIsNotExceeded(getFileSize() + StorageEntryHeader.sizeInBytes());
    assertChildDoesNotExist(childFilename);
    return dataManager().transactional(() -> {
      if (isEmpty()) {
        setStartingCluster(dataManager().occupyCluster(getStartingCluster()));
      }

      final StorageEntryHeader newEntry = StorageEntryHeader.create(isDirectory ? directoryAttribute() : fileAttribute(),
                                                                    childFilename,
                                                                    emptyCluster(),
                                                                    0,
                                                                    SystemUtil.currentTS(),
                                                                    getStartingCluster());
      newEntry.setDataManager(dataManager());
      final int headerOffset = getFileSize();
      setFileSize(getFileSize() + StorageEntryHeader.sizeInBytes());
      setModificationUnixTime(SystemUtil.currentTS());
      final byte[] content = newEntry.toByteArray();
      dataManager().writeContent(newEntry.toByteArray(), new StorageDataManager.OffsetRwState(getStartingCluster(), content.length, headerOffset));
      rewrite(getFilename());
      return newEntry;
    });
  }

  List<byte[]> getChildrenFilenames() {
    if (isEmpty()) {
      return Collections.emptyList();
    }
    final List<byte[]> childrenFilenames = new ArrayList<>();
    for (int i = 0; i < numberOfChildStorageEntries(); i++) {
      childrenFilenames.add(readFilenameByClusterNumberAndIndex(getStartingCluster(), i));
    }
    return childrenFilenames;
  }

  void deleteChild(@Nonnull final StorageEntryHeader child) {
    final int index = findChildIndexByFilename(child.getFilename());
    StorageEntryHeader.guardEntryIndex(index);
    final byte[] myHeaders = dataManager().readContent(new StorageDataManager.OffsetRwState(getStartingCluster(), getFileSize(), 0));
    dataManager().transactional(() -> {
      final byte[] newDirectoryContent = ByteUtil.compact(myHeaders, 0, index * headerByteSize(), headerByteSize());
      dataManager().writeContent(newDirectoryContent, new StorageDataManager.OffsetRwState(this.getStartingCluster(), getFileSize(), 0));
      setModificationUnixTime(SystemUtil.currentTS());
      setFileSize(getFileSize() - StorageEntryHeader.sizeInBytes());
      if (getFileSize() == 0) {
        freeOccupiedClusters();
        setStartingCluster(emptyCluster());
      }
      rewrite(getFilename());
      child.freeOccupiedClusters();
    });
  }

  boolean childExists(@Nonnull final byte[] filename) {
    return findChildIndexByFilename(filename) != nullEntryIndex();
  }

  StorageEntryHeader getChild(@Nonnull final byte[] filename) {
    final int index = findChildIndexByFilename(filename);
    if (index == nullEntryIndex()) {
      throw new StorageEntryHeaderNotFoundException();
    }
    return readChildHeaderAtIndex(index);
  }

  private void assertChildDoesNotExist(final byte[] filename) {
    if (childExists(filename)) {
      throw new StorageRecordAlreadyExistsException();
    }
  }

  private int numberOfChildStorageEntries() {
    return getFileSize() / sizeInBytes();
  }

  private int findChildIndexByFilename(@Nonnull final byte[] filename) {
    if (isEmpty()) {
      return nullEntryIndex();
    }
    return findEntryIndexByFilenameAndClusterNumber(filename, getStartingCluster());
  }

  private int findEntryIndexByFilenameAndClusterNumber(@Nonnull final byte[] filename, final int startingCluster) {
    return findEntryIndexByFilenameAndClusterNumberUnbound(filename, startingCluster, numberOfChildStorageEntries());
  }

  private StorageEntryHeader readChildHeaderAtIndex(final int index) {
    if (isEmpty()) {
      throw new StorageEntryHeaderNotFoundException();
    }
    return readHeaderByClusterNumberAndIndex(this.getStartingCluster(), index);
  }

  private StorageEntryHeader readHeaderByClusterNumberAndIndex(final int clusterNumber, final int index) {
    final StorageEntryHeader entryHeader = fromByteArray(dataManager().readContent(new StorageDataManager.OffsetRwState(clusterNumber, sizeInBytes(),
                                                                                                                        offsetByIndex(index))));
    entryHeader.setDataManager(dataManager());
    return entryHeader;
  }

  static final class Root extends StorageDirectoryEntryHeader {
    Root(final int numberOfEntries, final long modificationUnixTime) {
      super(ByteUtil.asciiStringToByteArray(getRootDirectoryName()),
            getRootDirectoryStartingClusterIndex(),
            directoryByteSize(numberOfEntries),
            modificationUnixTime,
            emptyCluster());
    }

    @Override
    void rewrite(@Nonnull final byte[] filename) {
      dataManager().updateRootDirectoryHeader();
    }
  }
}
