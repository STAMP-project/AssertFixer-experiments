package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.PlatformConstants;
import org.dimyriy.vfs.impl.exceptions.PlatformFileNotFoundException;
import org.dimyriy.vfs.impl.exceptions.StorageIOException;
import org.dimyriy.vfs.impl.exceptions.StorageIndexOutOfBoundsException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("SameParameterValue")
@NotThreadSafe
class BoundStorageReaderWriter implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoundStorageReaderWriter.class);
  //TODO: use pooled readers
  private final RandomAccessFile fileReader;
  private final RandomAccessFile fileWriter;
  private final PositiveLongRange allowedAccessByteRange;

  BoundStorageReaderWriter(@Nonnull final File file, @Nonnull final PositiveLongRange allowedAccessRange) {
    Assertions.fileExistsAndIsReadableAndIsWritable(file);
    try {
      this.fileReader = new RandomAccessFile(file, PlatformConstants.RANDOM_ACCESS_FILE_READ_MODE);
      this.fileWriter = new RandomAccessFile(file, PlatformConstants.RANDOM_ACCESS_FILE_READ_WRITE_MODE);
      this.allowedAccessByteRange = allowedAccessRange;
    } catch (final Exception e) {
      LOGGER.error("Underlying storage file has been removed during metadata processing", e);
      throw new PlatformFileNotFoundException();
    }
  }

  @Override
  public void close() {
    try {
      this.fileReader.close();
    } catch (final IOException e) {
      LOGGER.info("Got exception while trying to close reader randomAccessFile", e);
    } finally {
      try {
        this.fileWriter.close();
      } catch (final IOException e) {
        LOGGER.info("Got exception while trying to close writer randomAccessFile", e);
      }
    }
  }

  void write(final long offset, @Nonnull final byte[] data) {
    ensureAccessRange(offset, data);
    try {
      fileWriter.seek(offset);
      fileWriter.write(data);
    } catch (final IOException e) {
      throw new StorageIOException(e);
    }
  }

  byte[] read(final long offset, final int length) {
    ensureAccessRange(offset, length);
    try {
      final byte[] buffer = new byte[length];
      fileReader.seek(offset);
      fileReader.read(buffer);
      return buffer;
    } catch (final IOException e) {
      throw new StorageIOException(e);
    }
  }

  private void ensureAccessRange(final long offset, @Nonnull final byte[] data) {
    ensureAccessRange(offset, data.length);
  }

  private void ensureAccessRange(final long offset, final int length) {
    if (allowedAccessByteRange.isBothValuesInRange(offset, offset + length)) {
      throw new StorageIndexOutOfBoundsException();
    }
  }
}
