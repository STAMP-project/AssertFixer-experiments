package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.exceptions.StorageIndexOutOfBoundsException;
import org.dimyriy.vfs.impl.misc.PositiveLongRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 01.10.18
 */
class BoundStorageReaderWriterTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoundStorageReaderWriterTest.class);
  private File tempFile = null;

  @BeforeEach
  void setUp() throws IOException {
    tempFile = File.createTempFile("tmp", "vfs");
    final boolean existed = tempFile.createNewFile();
    LOGGER.trace("Created file {}", existed);
  }

  @Test
  void write_ThrowsException_WhenTryingToWriteOutsideOfRange() {
    Assertions.assertThrows(StorageIndexOutOfBoundsException.class,
                            () -> new BoundStorageReaderWriter(tempFile, new PositiveLongRange(0, 100), 1).write(100, new byte[]{1}));
  }

  @Test
  void write_DoesNotThrow_WhenTryingToWriteInsideRange() {
    Assertions.assertDoesNotThrow(
      () -> new BoundStorageReaderWriter(tempFile, new PositiveLongRange(0, 100), 1).write(99, new byte[0]));
  }

  @Test
  void read_ThrowsException_WhenTryingToReadOutsideOfRange() {
    Assertions.assertThrows(StorageIndexOutOfBoundsException.class,
                            () -> new BoundStorageReaderWriter(tempFile, new PositiveLongRange(0, 100), 1).read(0, 101));
  }

  @Test
  void read_DoesNotThrow_WhenTryingToReadInsideRange() {
    Assertions.assertDoesNotThrow(
      () -> new BoundStorageReaderWriter(tempFile, new PositiveLongRange(0, 100), 1).read(0, 100));
  }

  @Test
  void reads_SubsequentToWrite_ReadWrittenDataCorrectly() {
    final BoundStorageReaderWriter rw = new BoundStorageReaderWriter(tempFile, new PositiveLongRange(0, 100), 1);
    final byte[] written = {1, 2, 3, 4, 7, 1, 2};
    rw.write(15, written);
    assertThat(rw.read(15, written.length)).isEqualTo(written);
    assertThat(rw.read(15, written.length)).isEqualTo(written);
  }
}