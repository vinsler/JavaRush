package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        // 1. Программа должна использовать классы FileInputStream и FileOutputStream.
        FileInputStream inputStream = new FileInputStream("c:/tmp/data.txt");
        FileOutputStream outputStream = new FileOutputStream("c:/tmp/result.txt");

        if (inputStream.available() > 0)
        {
            // buffer = количеству не прочитанных байт
            byte[] buffer = new byte[inputStream.available()];

            //int count = inputStream.read(buffer); // так тоже не пропусает
            inputStream.read(buffer);

            // 2. Программа должна переписать все байты одного файла в другой одним куском.

            //outputStream.write(buffer, 0, count); // так тоже не пропускает
            outputStream.write(buffer);
        }
        //3. Потоки FileInputStream и FileOutputStream должны быть закрыты.
        inputStream.close();
        outputStream.close();
    }
}
