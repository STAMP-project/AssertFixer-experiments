package ru.job4j.tracker;

import java.io.File;
import java.io.IOException;

public class FileCreateSandBox {
    public static void main(String[] args) {
        File file = new File("temp.ini");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
