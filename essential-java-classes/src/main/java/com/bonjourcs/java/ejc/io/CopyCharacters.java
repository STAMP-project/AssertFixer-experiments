package com.bonjourcs.java.ejc.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Liang Chenghao
 * Description: copy characters with reader
 * Date: 2018/4/28
 */
public class CopyCharacters {

    public static void main(String[] args) throws IOException {

        FileReader reader = null;
        FileWriter writer = null;

        // get classpath
        String path1 = ClassLoader.getSystemResource("").getPath();

        try {
            reader = new FileReader(path1 + "file_read.txt");
            writer = new FileWriter(path1 + "file_write.txt");
            // copy file
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

    }
}
