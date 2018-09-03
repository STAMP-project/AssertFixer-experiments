package ru.job4j.filesearcher;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Visitor {
    private final String root;
    private final LinkedList<Path> files = new LinkedList<>();
    private final List<String> exts;

    public Visitor(String root, List<String> exts) {
        this.root = root;
        this.exts = exts;
    }

    public LinkedList<Path> getFiles() {
        LinkedList<Path> result = new LinkedList<>();
        for (Path path : files) {
            if (checkExtension(path)) {
                result.add(path);
            }
        }
        return result;
    }

    private boolean checkExtension(Path path) {
        for (String ext : exts) {
            if (ext.equals(getExtension(path))) {
                return true;
            }
        }
        return false;
    }
    public String getExtension(Path path) {
        String result = "";

        int i = path.toString().lastIndexOf('.');
        if (i >= 0) {
            result = path.toString().substring(i + 1);
        }
        return result;
    }

    public void walkThrough() throws IOException {

        Files.walkFileTree(Paths.get(root), new HashSet<>(), 7, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                //  System.out.println("preVisitDirectory: " + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                // System.out.println("visitFile: " + file);
                files.add(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc)
                    throws IOException {
                // System.out.println("visitFileFailed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                    throws IOException {
                // System.out.println("postVisitDirectory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
