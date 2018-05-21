package com.bonjourcs.java.ejc.io.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Liang Chenghao
 * Description: uitl tools to file
 * Date: 2018/5/21
 */
public class FileUtils {

    /**
     * classpath
     */
    private static final String CLASS_PATH = ClassLoader
            .getSystemResource("").getPath()
            .replaceFirst("/", "");

    /**
     * copy file
     *
     * @param originalFile original file
     * @param targetFile   target file
     * @throws IOException exception
     */
    public static void copyFile(String originalFile, String targetFile) throws IOException{

        Path originalPath = Paths.get(CLASS_PATH, originalFile);
        Path targetPath = Paths.get(CLASS_PATH, targetFile);

        Files.copy(originalPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void moveFile(String originalFile, String targetFile) throws IOException {

        Path originalPath = Paths.get(CLASS_PATH, originalFile);
        Path targetPath = Paths.get(CLASS_PATH, targetFile);

        Files.move(originalPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

}
