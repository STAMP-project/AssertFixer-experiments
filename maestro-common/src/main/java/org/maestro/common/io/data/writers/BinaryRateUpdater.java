/*
 * Copyright 2018 Otavio R. Piske <angusyoung@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.maestro.common.io.data.writers;

import org.maestro.common.Constants;
import org.maestro.common.io.data.common.FileHeader;
import org.maestro.common.io.data.common.RateEntry;
import org.maestro.common.io.data.common.exceptions.InvalidRecordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class BinaryRateUpdater implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(BinaryRateUpdater.class);

    private FileChannel fileChannel;

    // TODO: size needs to be adjusted accordingly
    private ByteBuffer byteBuffer = ByteBuffer.allocate(FileHeader.BYTES);

    /**
     * Constructor
     * @param reportFile the rate report file name
     * @throws IOException in case of I/O errors
     */
    public BinaryRateUpdater(final File reportFile) throws IOException {
        fileChannel = new RandomAccessFile(reportFile, "rw").getChannel();
    }

    private void write() throws IOException {
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            // TODO: use the other
            fileChannel.write(byteBuffer);
        }

        byteBuffer.flip();
        byteBuffer.clear();
    }


    public void updateHeader(final FileHeader header) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(header.getFormatName().getBytes());
        byteBuffer.putInt(header.getFileVersion());
        byteBuffer.putInt(Constants.VERSION_NUMERIC);
        byteBuffer.putInt(header.getRole().getCode());

        fileChannel.position(0);
        write();
    }


    /**
     * Writes a performance entry to the file
     * @param older older entry
     * @param newer newer entry
     * @throws IOException
     */
    private void update(RateEntry older, RateEntry newer) throws IOException {
        int remaining = byteBuffer.remaining();

        if (logger.isTraceEnabled()) {
            logger.trace("Remaining: {}", remaining);
        }

        if (remaining < (Integer.BYTES + Long.BYTES + Long.BYTES)) {
            write();
        }

        long olderTs = TimeUnit.MICROSECONDS.toSeconds(older.getTimestamp());
        long newerTs = TimeUnit.MICROSECONDS.toSeconds(newer.getTimestamp());

        if (olderTs != newerTs) {
            logger.error("Cannot update records that are not within the same second slot: {} == {}", olderTs, newerTs);
            throw new InvalidRecordException("Cannot save multiple records for within the same second slot");
        }

        byteBuffer.putInt(newer.getMetadata());
        byteBuffer.putLong(newer.getCount());
        byteBuffer.putLong(newer.getTimestamp());
    }

    public void update(RateEntry newer, long index) throws IOException {
        long pos = FileHeader.BYTES + (RateEntry.BYTES * index);

        fileChannel.position(pos);
        RateEntry older = readRecord(fileChannel, byteBuffer);

        byteBuffer.clear();
        byteBuffer.flip();
        fileChannel.position(pos);
        update(older, newer);
        write();
    }

    /**
     * Flushes the data to disk
     * @throws IOException in case of I/O errors
     */
    public void flush() throws IOException {
        write();
        fileChannel.force(true);
    }


    @Override
    public void close() {
        try {
            flush();
            fileChannel.close();
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(BinaryRateWriter.class);

            logger.error(e.getMessage(), e);
        }
    }


    private static RateEntry readRecord(FileChannel fileChannel, ByteBuffer byteBuffer) throws IOException {
        if (logger.isTraceEnabled()) {
            logBufferInfo(byteBuffer);
        }

        if (logger.isTraceEnabled()) {
            logger.trace("Read it all from the buffer. Fetching again from the channel");
        }

        byteBuffer.compact();
        int read = fileChannel.read(byteBuffer);
        if (read <= 0) {
            return null;
        }
        byteBuffer.flip();

        return new RateEntry(byteBuffer.getInt(), byteBuffer.getLong(), byteBuffer.getLong());
    }

    private static void logBufferInfo(final ByteBuffer byteBuffer) {
        logger.trace("Remaining: {}", byteBuffer.remaining());
        logger.trace("Position: {}", byteBuffer.position());
        logger.trace("Has Remaining: {}", byteBuffer.hasRemaining());
    }
}
