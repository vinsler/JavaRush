package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (
                f.isDirectory() ||
                f.getName().substring(f.getName().length()-4, f.getName().length()).toLowerCase().equals(".htm") ||
                f.getName().substring(f.getName().length()-5, f.getName().length()).toLowerCase().equals(".html")
                ) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
