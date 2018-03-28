package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        // 1. Программа должна три раза считать имена файлов с консоли.
        //String namefile1 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        //String namefile2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
        //String namefile3 = new BufferedReader(new InputStreamReader(System.in)).readLine();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String namefile1 = reader.readLine();
        String namefile2 = reader.readLine();
        String namefile3 = reader.readLine();
        reader.close();

        
        // 2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
        FileInputStream filereader1 = new FileInputStream(namefile1);
        FileOutputStream filewriter1 = new FileOutputStream(namefile2);
        FileOutputStream filewriter2 = new FileOutputStream(namefile3);



        int cx = filereader1.available();

        //byte[] buffer = new byte[filereader1.available()];

        if ((cx % 2) == 0){
            byte[] buffer1 = new byte[(filereader1.available() / 2)];
            filereader1.read(buffer1);
            filewriter1.write(buffer1);
            filereader1.read(buffer1);
            filewriter2.write(buffer1);
        }
        else {
            byte[] buffer1 = new byte[(filereader1.available()/ 2) + 1];
            filereader1.read(buffer1);
            filewriter1.write(buffer1);
            buffer1 = new byte[filereader1.available()];
            filereader1.read(buffer1);
            filewriter2.write(buffer1);
        }

        filereader1.close();
        filewriter1.close();
        filewriter2.close();
    }
}
