package ru.job4j.filesearcher;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.Searcher;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

@ThreadSafe
public class ParallelSearch {
    private String root;
    private final String text;
    private final Visitor visitor;
    private Searcher searcher = new Searcher();
    private Object monitor = new Object();
    private Path fileToSearch;
    volatile boolean finish = false;


    @GuardedBy("this")
    private final ConcurrentLinkedQueue<Path> files = new ConcurrentLinkedQueue();

    @GuardedBy("this")
    private final ConcurrentLinkedQueue<String> paths = new ConcurrentLinkedQueue<>();


    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        visitor = new Visitor(root, exts);
    }

    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    visitor.walkThrough();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (monitor) {
                    files.addAll(visitor.getFiles());
                    finish = true;
                }
                try {
                    notifyAll();
                } catch (IllegalMonitorStateException imse) {
                    imse.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }

        };
        Thread read = new Thread() {
            @Override
            public void run() {
                if (!finish) {
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (monitor) {
                    if (!files.isEmpty()) {
                        fileToSearch = files.poll();
                    }
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

        search.run();
        read.run();
    }

    synchronized Queue<String> result() {
        return (Queue<String>) this.paths;
    }
}