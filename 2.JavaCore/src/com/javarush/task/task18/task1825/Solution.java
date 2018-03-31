package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        /**
         * 1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
         * Каждый файл имеет имя Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
         * Заполняем список 'filelist' - вводимыми с консоли именами файлов, пока не введено 'end'
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> filelist = new ArrayList<String>();
        String filename = "";
        while (!"end".equals(filename = reader.readLine())){
            filelist.add(filename);
        }
        reader.close();
        Collections.sort(filelist);

        /**
         * 2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
         * Создаем папку, там сами создаем 3 файла для теста, именя которых вводим в консоле сами, ручками.
         */

        String filewithoutpart = filelist.get(filelist.size()-1);
        filename = filewithoutpart.substring(0, filewithoutpart.lastIndexOf('.'));
        //File file = new File("c:\\tmp\\1825"); // .part
        //file.mkdir();
        File file = new File(filename);
        FileOutputStream fileOutputStream = new FileOutputStream(filename);

        /**
         * 3. В новый файл перепиши все байты из файлов-частей *.partN.
         * 4. Чтение и запись должны происходить с использованием буфера.
         */
        byte [] buffer;
        FileInputStream fileInputStream = null;

        for (String lst : filelist) {
            //filename = lst;

            fileInputStream = new FileInputStream(lst);
            buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();

            //System.out.println(lst);

        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
