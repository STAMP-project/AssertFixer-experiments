package ru.job4j.tree;

import java.io.*;
import java.util.*;

public class WordIndex {
    BufferedReader reader;
    ArrayList<String> list = new ArrayList<>();
    Map<String, Set<Integer>> mainMap = new TreeMap<>();
    Set<Integer> temporyIndex = new TreeSet<>();
    ArrayList<String> temporyList = new ArrayList<>();

    protected void addString(String string) {
        list.add(string);
    }

    private void fileLoader(String fileName) {
        try {
            this.reader = new BufferedReader(new FileReader(fileName));
            addString(reader.readLine());
            while (reader.readLine() != null) {
                addString(reader.readLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void getBigStringList(ArrayList<String> list) {
        for (String string : list) {
            temporyList.addAll(Arrays.asList(string.split(" ")));
        }
    }

    public void loadFile(String filename) {
        //fileLoader(filename);
        getBigStringList(list);
        for (int j = 0; j < temporyList.size(); j++) {
            if (mainMap.containsKey(temporyList.get(j))) {
                continue;
            } else {
                for (int i = 0; i < temporyList.size(); i++) {
                    if (temporyList.get(j).equals(temporyList.get(i))) {
                        temporyIndex.add(i);
                    }
                }
            }
            mainMap.put(temporyList.get(j), temporyIndex);
            temporyIndex = new TreeSet<>();
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        return mainMap.get(searchWord);

    }
}
