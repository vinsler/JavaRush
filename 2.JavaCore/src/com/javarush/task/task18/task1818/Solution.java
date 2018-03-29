package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileOutputStream file1 = new FileOutputStream(filename1);
        FileInputStream file2 = new FileInputStream(filename2);
        FileInputStream file3 = new FileInputStream(filename3);

        while (file2.available() > 0){
            int b = file2.read();
            file1.write(b);
        }

/*        file1.write(13);
        file1.write(10);*/

        while (file3.available() > 0){
            int b = file3.read();
            file1.write(b);
        }

        file1.close();
        file2.close();
        file3.close();
    }
}
