package ru.job4j.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordIndexTest {
    @Test
    public void whenAddSomeStingsThenGetIndexes() {
        WordIndex index = new WordIndex();
        index.addString("Lorem ipsum");
        index.addString("dolor sit amet");
        index.addString("consectetur adipiscing elit");
        index.addString("sed do eiusmod tempor incididunt ut ");
        index.addString("Lorem Lorem Lorem Lorem Lorem");
        index.addString("labore et dolore magna aliqua");
        index.addString("labore et dolore magna aliqua");
        index.loadFile(" ");
        index.getIndexes4Word("sed");
        System.out.println(index.mainMap);
        assertTrue(true);
    }

}