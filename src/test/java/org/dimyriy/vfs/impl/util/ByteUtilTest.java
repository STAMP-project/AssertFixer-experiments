package org.dimyriy.vfs.impl.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
class ByteUtilTest {
  private int normalInt = 0;
  private byte[] bytedInt = null;
  private long normalLong = 0L;
  private byte[] bytedLong = null;
  private short normalShort = 0;
  private byte[] bytedShort = null;

  @BeforeEach
  void setUp() {
    normalLong = 0b1111_1101_0110_1000_1101_0110_0101_1110_1001_1010_0110_1011_0000_0010_1000_1110L;
    normalInt = 0b0111_10111_0110_1000_1101_0110_1101_1110;
    normalShort = (short) 0b0111_10111_0110_1000;
    bytedLong = new byte[]{
      (byte) 0b1111_1101,
      (byte) 0b0110_1000,
      (byte) 0b1101_0110,
      (byte) 0b0101_1110,
      (byte) 0b1001_1010,
      (byte) 0b0110_1011,
      (byte) 0b0000_0010,
      (byte) 0b1000_1110
    };

    bytedInt = new byte[]{
      (byte) 0b0111_10111,
      (byte) 0b0110_1000,
      (byte) 0b1101_0110,
      (byte) 0b1101_1110
    };

    bytedShort = new byte[]{
      (byte) 0b0111_10111,
      (byte) 0b0110_1000
    };
  }

  @Test
  void compact_ReturnsCorrectCompactedArray() {
    final byte[] sparseArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    final byte[] expected = {0, 0, 0, 4, 5, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0};
    Assertions.assertArrayEquals(ByteUtil.compact(sparseArray, 3, 2, 4), expected);
  }

  @Test
  void toByteArray_ReturnsCorrectLong_WhenArgIsLong() {
    Assertions.assertArrayEquals(bytedLong, ByteUtil.toByteArray(normalLong));
  }

  @Test
  void toByteArray_ReturnsCorrectInteger_WhenArgIsInt() {
    Assertions.assertArrayEquals(bytedInt, ByteUtil.toByteArray(normalInt));
  }

  @Test
  void toByteArray_ReturnsCorrectShort_WhenArgIsShort() {
    Assertions.assertArrayEquals(bytedShort, ByteUtil.toByteArray(normalShort));
  }

  @Test
  void toLong_ReturnsCorrectLong() {
    Assertions.assertEquals(normalLong, ByteUtil.toLong(bytedLong));
  }

  @Test
  void toInt_ReturnsCorrectInteger() {
    Assertions.assertEquals(normalInt, ByteUtil.toInt(bytedInt));
  }

  @Test
  void toShort_ReturnsCorrectShort() {
    Assertions.assertEquals(normalShort, ByteUtil.toShort(bytedShort));
  }

  @Test
  void toAsciiCharArrayOfAsciiCharArrayToByteArray_ReturnsArrayEqualToInitial() {
    final char[] expected = "abcdefg".toCharArray();
    Assertions.assertArrayEquals(expected, ByteUtil.toAsciiCharArray(ByteUtil.asciiCharArrayToByteArray(expected)));
  }

  @Test
  void toAsciiStringArrayOfAsciiStringToByteArray_ReturnsArrayEqualToInitial() {
    final String expected = "abcdefg";
    assertThat(ByteUtil.toAsciiString(ByteUtil.asciiStringToByteArray(expected))).isEqualTo(expected);
  }

  @Test
  void writeAtOffset_WritesCorrectData_WhenArgIsByteArray() {
    final byte[] data = {1, 2, 3, 4, 5, 6};
    final byte[] destination = new byte[16];
    final int offset = 9;
    ByteUtil.writeAtOffset(destination, offset, data);
    final byte[] expected = new byte[destination.length];
    System.arraycopy(data, 0, expected, offset, data.length);
    assertThat(destination).isEqualTo(expected);
  }

  @Test
  void writeIntAtOffset_WritesCorrectData() {
    final byte[] destination = new byte[16];
    final int offset = 9;
    ByteUtil.writeIntAtOffset(destination, offset, normalInt);
    final byte[] expected = new byte[destination.length];
    System.arraycopy(bytedInt, 0, expected, offset, bytedInt.length);
    assertThat(destination).isEqualTo(expected);
  }

  @Test
  void writeLongAtOffset_WritesCorrectData() {
    final byte[] destination = new byte[32];
    final int offset = 12;
    ByteUtil.writeLongAtOffset(destination, offset, normalLong);
    final byte[] expected = new byte[destination.length];
    System.arraycopy(bytedLong, 0, expected, offset, bytedLong.length);
    assertThat(destination).isEqualTo(expected);
  }

  @Test
  void writeByteAtOffset_WritesCorrectData() {
    final byte[] destination = new byte[32];
    final int offset = 12;
    final byte expected = (byte) 55;
    ByteUtil.writeByteAtOffset(destination, offset, expected);
    assertThat(destination[offset]).isEqualTo(expected);
  }

  @Test
  void readByteArrayAtOffset_ReadsCorrectData() {
    final byte[] source = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 0};
    final byte[] expected = {1, 2, 3, 4, 5, 6};
    assertThat(ByteUtil.readByteArrayAtOffset(source, 9, 6)).isEqualTo(expected);
  }

  @Test
  void readIntAtOffsetReadsCorrectData() {
    final byte[] source = new byte[16];
    final int offset = 3;
    System.arraycopy(bytedInt, 0, source, offset, bytedInt.length);
    assertThat(ByteUtil.readIntAtOffset(source, offset)).isEqualTo(normalInt);
  }

  @Test
  void readLongAtOffsetReadsCorrectData() {
    final byte[] source = new byte[32];
    final int offset = 3;
    System.arraycopy(bytedLong, 0, source, offset, bytedLong.length);
    assertThat(ByteUtil.readLongAtOffset(source, offset)).isEqualTo(normalLong);
  }

  @Test
  void readByteAtOffsetReadsCorrectData() {
    final byte[] source = new byte[16];
    final int offset = 3;
    final byte expected = 55;
    source[offset] = expected;
    assertThat(ByteUtil.readByteAtOffset(source, offset)).isEqualTo(expected);
  }
}