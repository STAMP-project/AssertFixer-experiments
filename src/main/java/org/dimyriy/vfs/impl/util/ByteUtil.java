package org.dimyriy.vfs.impl.util;

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

  public static byte[] asciiStringToByteArray(final String asciiString) {
    if (!asciiString.chars().allMatch(c -> c < 128)) {
      throw new StringContainsNonAsciiCharactersException();
    }
    return ByteUtil.asciiCharArrayToByteArray(asciiString.toCharArray());
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

  public static char[] toAsciiCharArray(@Nonnull final byte[] array) {
    final char[] result = new char[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = (char) array[i];
    }
    return result;
  }

  public static byte[] toByteArray(final int n) {
    final ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
    buffer.putInt(n);
    return buffer.array();
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

  private static void readAtOffset(final byte[] source, final int offset, final byte[] destination) {
    System.arraycopy(source, offset, destination, 0, destination.length);
  }
}
