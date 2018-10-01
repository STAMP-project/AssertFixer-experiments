package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.PlatformConstants;
import org.dimyriy.vfs.impl.exceptions.InitializationException;
import org.dimyriy.vfs.impl.exceptions.StorageIOException;
import org.dimyriy.vfs.impl.exceptions.StorageIndexOutOfBoundsException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.LruPool;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.io.*;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("SameParameterValue")
@NotThreadSafe
class BoundStorageReaderWriter implements Closeable {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoundStorageReaderWriter.class);
  private final RandomAccessFile fileWriter;
  private final PositiveLongRange allowedAccessByteRange;
  private final LruPool<RandomAccessFile> readerPool;

  BoundStorageReaderWriter(@Nonnull final File file, @Nonnull final PositiveLongRange allowedAccessRange, final int readersCacheSize) {
    Assertions.fileExistsAndIsReadableAndIsWritable(file);
    try {
      this.allowedAccessByteRange = allowedAccessRange;
      this.fileWriter = new RandomAccessFile(file, PlatformConstants.RANDOM_ACCESS_FILE_READ_WRITE_MODE);
      this.readerPool = new LruPool<>(readersCacheSize, () -> {
        try {
          return new RandomAccessFile(file, PlatformConstants.RANDOM_ACCESS_FILE_READ_MODE);
        } catch (final FileNotFoundException e) {
          LOGGER.warn("Underlying file for FS not found", e);
          throw new StorageIOException(e);
        }
      });
    } catch (final Exception e) {
      LOGGER.error("Unable to create accessor for provided file", e);
      throw new InitializationException(e);
    }
  }

  @Override
  public void close() throws IOException {
    LOGGER.trace("Closing started");
    final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
    LOGGER.trace("Closing readers pool");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, readerPool);
    LOGGER.trace("Closing writer");
    ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, fileWriter);
    if (thrown.getValue() != null) {
      LOGGER.warn("Closing failed", thrown.getValue());
      throw thrown.getValue();
    } else {
      LOGGER.trace("Closing finished");
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
      final RandomAccessFile fileReader = readerPool.borrowObject();
      fileReader.seek(offset);
      fileReader.read(buffer);
      readerPool.putObject(fileReader);
      return buffer;
    } catch (final IOException e) {
      throw new StorageIOException(e);
    }
  }


  private void ensureAccessRange(final long offset, @Nonnull final byte[] data) {
    ensureAccessRange(offset, data.length);
  }

  private void ensureAccessRange(final long offset, final int length) {
    if (!allowedAccessByteRange.isBothValuesInRange(offset, offset + length - 1)) {
      throw new StorageIndexOutOfBoundsException();
    }
  }
}
