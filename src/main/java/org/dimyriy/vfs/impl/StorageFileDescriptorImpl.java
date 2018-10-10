package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageFileDescriptor;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.impl.exceptions.NotEnoughSpaceLeftException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordAlreadyExistsException;
import org.dimyriy.vfs.impl.exceptions.StorageRecordCorruptedException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.ByteUtil;

import javax.annotation.Nonnull;
import java.nio.BufferUnderflowException;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
class StorageFileDescriptorImpl extends AbstractStorageRecordDescriptorImpl implements StorageFileDescriptor {
  StorageFileDescriptorImpl(@Nonnull final StoragePath storagePath,
                            @Nonnull final StorageFileEntryHeader entryHeader,
                            @Nonnull final InfileFileSystem owner) {
    super(storagePath, entryHeader, owner);
  }

  @Override
  public int size() {
    return header().getFileSize();
  }

  @Override
  public StorageFileEntryHeader header() {
    return (StorageFileEntryHeader) super.header();
  }

  @Override
  public byte[] read() {
    guardNotClosedNotDeleted();
    return fs().inReadContext(() -> {
      final byte[] buffer = new byte[header().getFileSize()];
      header().readContent(0, header().getFileSize(), buffer);
      return buffer;
    });
  }

  @Override
  public void readAtOffsetToBuffer(final int offset, final int length, @Nonnull final byte[] buffer) {
    guardNotClosedNotDeleted();
    fs().inReadContext(() -> {
      guardNotClosedNotDeleted();
      try {
        header().readContent(offset, length, buffer);
      } catch (final BufferUnderflowException e) {
        fs().processCorruptedEntry(header());
        throw new StorageRecordCorruptedException();
      }
      return null;
    });
  }

  @Override
  public void write(@Nonnull final byte[] content) {
    guardNotClosedNotDeleted();
    assertEnoughEmptyClusters(content.length);
    fs().inWriteContext(() -> {
      guardNotClosedNotDeleted();
      header().writeFileContentAtOffset(content, 0);
    });
  }

  @Override
  public void append(@Nonnull final byte[] content) {
    guardNotClosedNotDeleted();
    assertEnoughEmptyClusters(header().getFileSize() + content.length);
    fs().inWriteContext(() -> {
      guardNotClosedNotDeleted();
      if (header().isEmpty()) {
        header().writeFileContentAtOffset(content, 0);
      } else {
        dataManager().transactional(() -> header().writeFileContentAtOffset(content, header().getFileSize()));
      }
    });
  }

  @Override
  public void rename(@Nonnull final String newName) {
    guardClosed();
    guardDeleted();
    Assertions.filenameMatchesPattern(newName);
    fs().inWriteContext(() -> {
      guardClosed();
      guardDeleted();
      final StoragePath oldPath = getPath();
      final byte[] newNameArray = ByteUtil.asciiStringToByteArray(newName);
      if (header().siblingExists(newNameArray)) {
        throw new StorageRecordAlreadyExistsException();
      } else {
        header().rename(newNameArray);
        updatePath(getPath().parent().child(newName));
        fs().notifyRenamed(this, oldPath);
      }
    });
  }


  private void assertEnoughEmptyClusters(final int size) {
    if (size >= fs().getFreeSpace()) {
      throw new NotEnoughSpaceLeftException();
    }
  }
}
