package com.bonjourcs.java.ejc.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/4
 */
public class ExceptionDemo {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ExceptionDemo() {
        list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(new File("out_file.txt"));

        for (int i = 0; i < SIZE; i++) {
            writer.println("Value at: " + i + " is " + list.get(i));
        }

        writer.close();

    }
}
