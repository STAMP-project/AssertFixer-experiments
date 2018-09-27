package org.dimyriy.vfs.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.dimyriy.vfs.impl.constants.MetadataConstants.LENGTH;
import static org.dimyriy.vfs.impl.constants.MetadataConstants.OFFSET;

/**
 * @author Dmitrii Bogdanov
 * Created at 27.09.18
 */
@SuppressWarnings("unused")
public class Util {
  private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

  public static byte[] readMetadataFromFile(final File expected) throws IOException {
    return readFileContentAtOffset(expected,
                                   OFFSET,
                                   LENGTH);
  }

  @SuppressWarnings("SameParameterValue")
  private static byte[] readFileContentAtOffset(final File expected, final int offset, final int length) throws IOException {
    try (final FileInputStream expectedInputStream = new FileInputStream(expected)) {
      final byte[] content = new byte[length];
      final int read = expectedInputStream.read(content, offset, length);
      LOGGER.trace("Read {} bytes", read);
      return content;
    }
  }
}
