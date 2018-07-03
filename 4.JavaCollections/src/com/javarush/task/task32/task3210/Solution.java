package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String filename = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            raf.seek(number);
            byte [] buffer = new byte[text.length()];
            raf.read(buffer, 0 , text.length());

            raf.seek(raf.length());
            String str = new String(buffer);

            if (str.equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
