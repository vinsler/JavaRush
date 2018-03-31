package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename= null;
        while (true) {
            try {
                filename = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(filename);
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                reader.close();
                System.out.println(filename);
                break;
            }
        }
    }
}
