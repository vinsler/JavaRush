package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        /*"c:/tmp/fr1.txt";
        "c:/tmp/fr2.txt";*/

        //2. Для первого файла создай поток для чтения и считай его содержимое.

        FileInputStream fileInputStream1 = new FileInputStream(filename1);
        byte [] buffer1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);
        fileInputStream1.close();

        //3. Затем, для первого файла создай поток для записи. Для второго - для чтения.

        FileOutputStream fileOutputStream1 = new FileOutputStream(filename1);
        FileInputStream fileInputStream2 = new FileInputStream(filename2);

        // 4. Содержимое первого и второго файла нужно объединить в первом файле.
        // 5. Сначала должно идти содержимое второго файла, затем содержимое первого.
        // идеально, сначало напиши 4ый пункт, а потом перепиши его под 5-ый

        byte [] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);

        fileOutputStream1.write(buffer2);
        fileOutputStream1.write(buffer1);


        fileInputStream2.close();
        fileOutputStream1.close();


    }
}
