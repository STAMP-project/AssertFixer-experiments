package com.bonjourcs.java.ejc.io.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/5/21
 */
public class FileUtilsTest {

    @Test
    public void testCopyFile() throws IOException {
        FileUtils.copyFile("file_original.txt", "file_original_copy.txt");
    }

    @Test
    public void testMoveFile() throws IOException {
        // rename file
        FileUtils.moveFile("file_original.txt", "file_original_move.txt");
        // rename back
        FileUtils.moveFile("file_original_move.txt", "file_original.txt");
    }

}