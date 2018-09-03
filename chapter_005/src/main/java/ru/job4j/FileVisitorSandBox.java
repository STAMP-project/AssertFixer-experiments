package ru.job4j;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.LinkedList;


public class FileVisitorSandBox {
    public static void main(String... args) throws IOException {
        String root = "D:\\";
        LinkedList<Path> files = new LinkedList<>();
        Files.walkFileTree(Paths.get(root), new HashSet<>(), 2, new FileVisitor<Path>() {
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
        for (Path path : files
                ) {
            System.out.println(files.peek());
        }


    }
}
