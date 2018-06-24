package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> listFiles = new ArrayList<>(); // список для записи файлов
        Queue<File> listQueue = new PriorityQueue<>(); // очередь для добавления файлов из папок
        File dir = new File(root); // папка корень

        Collections.addAll(listQueue, dir.listFiles()); // добавляем в очередь все файлы из папки корня
        while (!listQueue.isEmpty()) { // пока есть файлы в очереди
            File fileForDelFromQueue = listQueue.remove(); // удаляем файл из очереди
            if (fileForDelFromQueue.isDirectory()) { // если он папка ?
                Collections.addAll(listQueue, fileForDelFromQueue.listFiles()); // то добавляем все файлы к очереди

            } else {
                listFiles.add(fileForDelFromQueue.getAbsolutePath()); // если нет, то добавляем файл к списку файлов
            }
        }
        return listFiles;
    }

    public static void main(String[] args) {
        
    }
}
