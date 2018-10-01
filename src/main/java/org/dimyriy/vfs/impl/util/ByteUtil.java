package org.dimyriy.vfs.impl.util;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.StringContainsNonAsciiCharactersException;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;

/**
 * @author Dmitrii Bogdanov
 * Created at 24.09.18
 */
public final class ByteUtil {

  private ByteUtil() {
  }

  public static boolean stringContainsNonAsciiChars(@Nonnull final String string) {
    return string.chars().anyMatch(c -> c >= 128);
  }

  public static byte[] asciiStringToByteArray(@Nonnull final String asciiString) {
    if (stringContainsNonAsciiChars(asciiString)) {
      throw new StringContainsNonAsciiCharactersException();
    }
    final byte[] bytes = ByteUtil.asciiCharArrayToByteArray(asciiString.toCharArray());
    final byte[] filename = new byte[StorageConstants.MAX_FILENAME_LENGTH_IN_BYTES];
    System.arraycopy(bytes, 0, filename, 0, bytes.length);
    return filename;
  }

  public static byte[] compact(@Nonnull final byte[] bytes, final int offset, final int startIndex, final int emptyIntervalLength) {
    final byte[] compacted = new byte[bytes.length];
    System.arraycopy(bytes, offset, compacted, offset, startIndex);
    System.arraycopy(bytes,
                     offset + startIndex + emptyIntervalLength,
                     compacted,
                     offset + startIndex,
                     bytes.length - emptyIntervalLength - startIndex - offset);
    return compacted;
  }

  public static int toInt(@Nonnull final byte[] bytes) {
    final ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
    buffer.put(bytes);
    buffer.flip();
    return buffer.getInt();
  }

  public static int readIntAtOffset(@Nonnull final byte[] source, final int offset) {
    final byte[] read = readByteArrayAtOffset(source, offset, Integer.BYTES);
    return toInt(read);
  }

  public static long readLongAtOffset(@Nonnull final byte[] source, final int offset) {
    final byte[] read = readByteArrayAtOffset(source, offset, Long.BYTES);
    return toLong(read);
  }

  public static byte readByteAtOffset(@Nonnull final byte[] source, final int offset) {
    return source[offset];
  }

  public static byte[] readByteArrayAtOffset(@Nonnull final byte[] source, final int offset, final int length) {
    final byte[] read = new byte[length];
    readAtOffset(source, offset, read);
    return read;
  }

  public static void writeShortAtOffset(@Nonnull final byte[] destination, final int offset, final short data) {
    writeAtOffset(destination, offset, toByteArray(data));
  }

  public static void writeIntAtOffset(@Nonnull final byte[] destination, final int offset, final int data) {
    writeAtOffset(destination, offset, toByteArray(data));
  }

  public static void writeLongAtOffset(@Nonnull final byte[] destination, final int offset, final long data) {
    writeAtOffset(destination, offset, toByteArray(data));
  }

  public static void writeByteAtOffset(@Nonnull final byte[] destination, final int offset, final byte data) {
    destination[offset] = data;
  }

  public static byte[] asciiCharArrayToByteArray(@Nonnull final char[] array) {
    final byte[] result = new byte[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = (byte) array[i];
    }
    return result;
  }

  public static void writeAtOffset(@Nonnull final byte[] destination, final int offset, @Nonnull final byte[] data) {
    System.arraycopy(data, 0, destination, offset, data.length);
  }

  public static byte[] toByteArray(final short n) {
    final ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
    buffer.putShort(n);
    return buffer.array();
  }

  public static byte[] toByteArray(final int n) {
    final ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
    buffer.putInt(n);
    return buffer.array();
  }

  public static String toAsciiString(@Nonnull final byte[] array) {
    char[] charArray = toAsciiCharArray(array);
    int lastNonZeroChar = -1;
    for (int i = charArray.length - 1; i > 0; i--) {
      if (charArray[i] == 0) {
        lastNonZeroChar = i;
      } else {
        break;
      }
    }
    if (lastNonZeroChar != -1) {
      final char[] newCharArray = new char[lastNonZeroChar];
      System.arraycopy(charArray, 0, newCharArray, 0, newCharArray.length);
      charArray = newCharArray;
    }
    return new String(charArray);
  }

  public static short readShortAtOffset(@Nonnull final byte[] source, final int offset) {
    return toShort(readByteArrayAtOffset(source, offset, Short.BYTES));
  }

  static char[] toAsciiCharArray(@Nonnull final byte[] array) {
    final char[] result = new char[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = (char) array[i];
    }
    return result;
  }

  static byte[] toByteArray(final long n) {
    final ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    buffer.putLong(n);
    return buffer.array();
  }

  static long toLong(final byte[] bytes) {
    final ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    buffer.put(bytes);
    buffer.flip();
    return buffer.getLong();
  }

  static short toShort(final byte[] bytes) {
    final ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
    buffer.put(bytes);
    buffer.flip();
    return buffer.getShort();
  }

  private static void readAtOffset(final byte[] source, final int offset, final byte[] destination) {
    System.arraycopy(source, offset, destination, 0, destination.length);
  }
}
