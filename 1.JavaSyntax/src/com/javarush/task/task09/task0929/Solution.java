package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine(); // имя файла источник
        String destinationFileName = reader.readLine(); // имя файла назначения


        InputStream fileInputStream;

        try
            {
                fileInputStream = getInputStream(sourceFileName); // входящий поток
            }
            catch (Exception e)
            {
                System.out.println("Файл не существует.");
                sourceFileName = reader.readLine(); // имя файла источник
                fileInputStream = getInputStream(sourceFileName); // входящий поток
            }

            OutputStream fileOutputStream = getOutputStream(destinationFileName);  // исходящий поток

            while (fileInputStream.available() > 0) {  // пока входящий поток больше нуля
                int data = fileInputStream.read();  // читаем в дата входящий потом
                fileOutputStream.write(data);  // пишем в исходящий поток из дата
            }

            fileInputStream.close(); // закрываем файл
            fileOutputStream.close();

    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

