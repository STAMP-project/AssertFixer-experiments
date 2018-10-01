package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.util.ByteUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.dimyriy.vfs.impl.constants.FileAllocationTableConstants.emptyCluster;
import static org.dimyriy.vfs.impl.constants.StorageConstants.fileAttribute;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
class StorageEntryHeaderTest {
  private final byte[] headerArray = {0, 115, 111, 109, 101, 95, 102, 105, 108, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1};
  private final byte[] fileName = ByteUtil.asciiCharArrayToByteArray("some_file".toCharArray());
  private final StorageEntryHeader headerObject = new StorageEntryHeader(fileAttribute(), fileName, 0, 0, 0L, emptyCluster());
  private int offset = 0;
  private byte[] headerArrayWithOffset = null;

  @BeforeEach
  void setUp() {
    offset = 15;
    headerArrayWithOffset = new byte[headerArray.length + offset];
    System.arraycopy(headerArray, 0, headerArrayWithOffset, offset, headerArray.length);
  }

  @Test
  void toByteArrayWritesCorrectDataToByteArray() {
    assertThat(headerObject.toByteArray()).isEqualTo(headerArray);
  }

  @Test
  void fromByteArrayReadsCorrectDataFromByteArray() {
    assertThat(StorageEntryHeader.fromByteArray(headerArray)).isEqualToComparingFieldByField(headerObject);
  }

  @Test
  void fromByteArrayReadsCorrectDataFromByteArrayAtOffset() {
    assertThat(StorageEntryHeader.fromByteArray(headerArrayWithOffset, offset)).isEqualToComparingFieldByField(headerObject);
  }

  @Test
  void fromByteArrayOfToByteArrayReturnsEqualObject() {
    assertThat(StorageEntryHeader.fromByteArray(headerObject.toByteArray())).isEqualToComparingFieldByField(headerObject);
  }
}