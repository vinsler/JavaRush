package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<File> listFile50 = new ArrayList<>();
        String path, resultFileAbsolutePath = null;
        path = args[0];
        resultFileAbsolutePath = args[1];

        File fileRFA = new File(resultFileAbsolutePath);
        File newFile = new File(fileRFA.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(fileRFA, newFile);

        recFileForList(path, listFile50);
        Collections.sort(listFile50, Comparator.comparing(File::getName));

        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        FileInputStream fileInputStream;

        for (File f : listFile50) {
            if (!f.getName().equals(newFile.getName())) {
                fileInputStream = new FileInputStream(f);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write('\n');
                fileOutputStream.flush();
                fileInputStream.close();
            }
        }
        fileOutputStream.close();
    }

    public static void recFileForList(String path, ArrayList<File> list) {
        File [] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                recFileForList(file.getAbsolutePath(), list);
                continue;
            }
            if (file.length() <= 50) {
                list.add(file);
            }
        }
    }
}
