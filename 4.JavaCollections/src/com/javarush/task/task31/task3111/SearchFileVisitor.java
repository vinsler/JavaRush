package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private List<Path> foundFiles = new ArrayList<>();
    private int minSize = -1, maxSize = -1;

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String str = new String(Files.readAllBytes(file));
        if
            (
        (partOfName == null || file.getFileName().toString().contains(partOfName))
        && (partOfContent == null || str.contains(partOfContent))
        && (maxSize == -1 || Files.size(file) < maxSize)
        && (minSize == -1 || Files.size(file) > minSize)
                )
        {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}

/*
if (partOfName != null && file.getFileName().toString().contains(partOfName)) {
        foundFiles.add(file);
        }
        if (partOfContent != null && str.contains(partOfContent)) {
        foundFiles.add(file);
        }
        if (maxSize > -1 && Files.size(file) < maxSize) {
        foundFiles.add(file);
        }
        if (minSize > -1 && Files.size(file) > minSize) {
        foundFiles.add(file);
        }*/


