package com.bonjourcs.java.ejc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Liang Chenghao
 * Description: copy a file by bytes.
 * Date: 2018/4/16
 */
public class CopyBytes {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        // get classpath
        String path1 = ClassLoader.getSystemResource("").getPath();

        fileInputStream = new FileInputStream(path1 + "file_in.txt");
        fileOutputStream = new FileOutputStream(path1 + "file_out.txt");

        int ch;
        while ((ch = fileInputStream.read()) != -1) {
            fileOutputStream.write(ch);
        }

        fileOutputStream.close();
        fileInputStream.close();

    }
}
