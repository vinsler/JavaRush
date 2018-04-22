package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset UTF8 = Charset.forName("UTF-8");

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(UTF8);
        outputStream.write(buffer);

        inputStream.close();
        outputStream.close();
    }
}
