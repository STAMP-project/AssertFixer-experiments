package ru.job4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Searcher {

    private String text;

    BufferedReader reader;

    public boolean searchText(Path path, String text) throws IOException {
        reader = new BufferedReader(new FileReader(path.toString()));
        Path path1 = path;
        this.text = text;
        String line = null;
        boolean result = false;

        while ((line = reader.readLine()) != null) {
            if (this.checkSubstring(line)) {
                result = true;
                if (result) {
                    break;
                }
            }
        }
        return result;
    }

    private boolean checkSubstring(String line) {
        return line.contains(text);
    }
}
