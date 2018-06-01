package io.caiwan.utils.test.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.output.TeeOutputStream;

import lombok.Getter;

/**
 * @author caiwan
 * <p>
 * this proxy class will encapsulate two simultanious output streams to
 * help with testing XML build/parse features
 */

public class TestFileOutputStreamProxy extends OutputStream {
    @Getter
    private File file;

    @Getter
    private ByteArrayOutputStream byteStream;

    private FileOutputStream fileStream;

    private TeeOutputStream teeStream;

    public TestFileOutputStreamProxy(String filename) {
        file = new File(filename);
    }

    public TestFileOutputStreamProxy(File file) {
        this.file = file;
    }


    public void createStrems() throws IOException {
        byteStream = new ByteArrayOutputStream();
        fileStream = new FileOutputStream(file);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        teeStream = new TeeOutputStream(fileStream, byteStream);
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(byteStream.toByteArray());
    }

    @Override
    public void write(int b) throws IOException {
        teeStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        teeStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        teeStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        teeStream.flush();
    }

    @Override
    public void close() throws IOException {
        // will close both enclosed stream
        teeStream.close();
    }

}
