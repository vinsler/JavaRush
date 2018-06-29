package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path pathToDir = Paths.get(bufferedReader.readLine());
        bufferedReader.close();
        if (!Files.isDirectory(pathToDir)) {
            System.out.println(pathToDir.toAbsolutePath().toString() + " - не папка");
        } else {
            Visit vis = new Visit();
            Files.walkFileTree(pathToDir, vis);
            System.out.println("Всего папок - " + vis.cxDir);
            System.out.println("Всего файлов - " + vis.cxFile);
            System.out.println("Общий размер - " + vis.cxSize);
        }
    }

    private static class Visit extends SimpleFileVisitor<Path> {
        long cxFile = 0;
        long cxDir = -1;
        long cxSize = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            cxDir++;
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            cxFile++;
            cxSize = cxSize + attrs.size();
            return FileVisitResult.CONTINUE;
        }
    }
}
