package ru.job4j.filesearcher;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.Searcher;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

@ThreadSafe
public class ParallelSearchBQimpl {

    private final String text;
    private final Visitor visitor;
    private Searcher searcher = new Searcher();
    private Path fileToSearch;
    volatile boolean finish = false;


    public ParallelSearchBQimpl(String root, String text, List<String> exts) {
        String root1 = root;
        this.text = text;
        List<String> exts1 = exts;
        visitor = new Visitor(root, exts);
    }

    @GuardedBy("this")
    private final ArrayBlockingQueue<Path> files = new ArrayBlockingQueue(10);

    @GuardedBy("this")
    private final ArrayBlockingQueue<String> paths = new ArrayBlockingQueue(10);

    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    visitor.walkThrough();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                files.addAll(visitor.getFiles());
            }
        };

        Thread read = new Thread() {

            @Override
            public void run() {

                try {
                    fileToSearch = files.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if (fileToSearch != null
                            && searcher.searchText(fileToSearch, text)) {
                        paths.add(fileToSearch.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        search.start();
        read.start();
    }

    Queue<String> result() {
        return (Queue<String>) this.paths;
    }
}

