package ru.job4j.filesearcher;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParallelSearchBQimplTest {


    @Test
    public void whenTextSearchedThenFound() {
        String root = new File(".").getAbsolutePath();
        String text = "Lorem";

        List<String> exts = new ArrayList<>();
        exts.add("txt");
        ParallelSearchBQimpl search = new ParallelSearchBQimpl(root, text, exts);
        search.init();
        System.out.println(search.result().peek());
        Visitor extensionHelper = new Visitor("blankString", exts);
        assertEquals(exts.get(0), extensionHelper.getExtension(Paths.get(search.result().poll())));
    }

    @Test
    public void whenUseOnlyVisitorThenCheckIt() {
        String root = new File(".").getAbsolutePath();
        List<String> exts = new ArrayList<>();
        exts.add("txt");
        Visitor visitor = new Visitor(root, exts);
        try {
            visitor.walkThrough();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(visitor.getFiles().poll());
    }

    @Test
    public void whenTextSearchedThenNotFound() {
        String root = new File(".").getAbsolutePath();
        String text = "StringNotToFind";
        List<String> exts = new ArrayList<>();
        exts.add("txt");
        ParallelSearchBQimpl search = new ParallelSearchBQimpl(root, text, exts);
        search.init();
        System.out.println(search.result().peek());
        Visitor extensionHelper = new Visitor("blankString", exts);
        assertNull(search.result().poll());
    }

}