package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        String filename = null;
        int number = 0;
        String text = null;
        try {
            filename = args[0];
            number = Integer.parseInt(args[1]);
            text = args[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Does not have any argument");
            return;
        }

        RandomAccessFile raf;

        try {
            raf = new RandomAccessFile(filename, "rw");
            if (raf.length() < number) {
                raf.seek(raf.length());
                raf.write(text.getBytes());
            } else {
                raf.seek(number);
                raf.write(text.getBytes());
            }
            raf.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR, file not found!");
        } catch (IOException e) {
            System.out.println("ERROR, IO exception in raf.seek()");
        }
    }
}
