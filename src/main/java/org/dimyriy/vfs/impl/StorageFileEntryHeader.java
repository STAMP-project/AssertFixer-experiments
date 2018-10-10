package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.constants.StorageConstants;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 03.10.18
 */
class StorageFileEntryHeader extends StorageEntryHeader {
  StorageFileEntryHeader(@Nonnull final byte[] filename,
                         final int startingCluster,
                         final int fileSize,
                         final long modificationUnixTime,
                         final int parentDirectoryCluster) {
    super(StorageConstants.fileAttribute(), filename, startingCluster, fileSize, modificationUnixTime, parentDirectoryCluster);
  }

  void readContent(final int offset, final int length, @Nonnull final byte[] buffer) {
    if (!isEmpty()) {
      final StorageDataManager.OffsetRwState offsetRwState = new StorageDataManager.OffsetRwState(getStartingCluster(), length, offset);
      System.arraycopy(dataManager().readContent(offsetRwState), 0, buffer, 0, length);
    }
  }

  void writeFileContentAtOffset(final byte[] content, final int offset) {
    dataManager().transactional(() -> {
      if (getStartingCluster() == FileAllocationTableConstants.emptyCluster()) {
        setStartingCluster(dataManager().occupyCluster(getStartingCluster()));
      }
      final int oldFilesize = getFileSize();
      if (oldFilesize <= content.length + offset) {
        if (content.length + (long) offset >= Integer.MAX_VALUE) {
          throw new IllegalArgumentException("File is too large.");
        }
        setFileSize(content.length + offset);
      }
      dataManager().writeContent(content, new StorageDataManager.OffsetRwState(getStartingCluster(), content.length, offset));
      rewrite(this.getFilename());
    });
  }
}
