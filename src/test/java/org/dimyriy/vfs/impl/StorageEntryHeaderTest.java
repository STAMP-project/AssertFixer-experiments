package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
class StorageEntryHeaderTest {
  private final byte[] fatArray = {0, 115, 111, 109, 101, 95, 102, 105, 108, 101, 0, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
  private final byte[] fileName = ByteUtil.asciiCharArrayToByteArray("some_file".toCharArray());
  private final StorageEntryHeader fatEntry = new StorageEntryHeader(fileName, FileAllocationTableConstants.EMPTY_CLUSTER, 0, 0L, (byte) 0);
  private int offset = 0;
  private byte[] fatArrayWithOffset = null;

  @BeforeEach
  void setUp() {
    offset = 15;
    fatArrayWithOffset = new byte[fatArray.length + offset];
    System.arraycopy(fatArray, 0, fatArrayWithOffset, offset, fatArray.length);
  }

  @Test
  void toByteArrayWritesCorrectDataToByteArray() {
    assertThat(fatEntry.toByteArray()).isEqualTo(fatArray);
  }

  @Test
  void fromByteArrayReadsCorrectDataFromByteArray() {
    assertThat(StorageEntryHeader.fromByteArray(fatArray)).isEqualToComparingFieldByField(fatEntry);
  }

  @Test
  void fromByteArrayReadsCorrectDataFromByteArrayAtOffset() {
    assertThat(StorageEntryHeader.fromByteArray(fatArrayWithOffset, offset)).isEqualToComparingFieldByField(fatEntry);
  }

  @Test
  void fromByteArrayOfToByteArrayReturnsEqualObject() {
    assertThat(StorageEntryHeader.fromByteArray(fatEntry.toByteArray())).isEqualToComparingFieldByField(fatEntry);
  }
}