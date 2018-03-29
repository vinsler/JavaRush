package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            String filename = reader.readLine(); // "c:/tmp/data.txt"; //
            FileInputStream filestream = new FileInputStream(filename);

            if (filestream.available() < 1000){
                filestream.close();
                throw new DownloadException();
            }
        } while (true);
    }

    public static class DownloadException extends Exception {
    }
}
