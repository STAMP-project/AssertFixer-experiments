package com.bonjourcs.java.ejc.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Liang Chenghao
 * Description: class try with resource
 * Date: 2018/4/4
 */
public class TryWithResource {

    public static void readFile(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Read line: " + line);
            }
        }
    }

}
