package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int cx = 0;

        while (bufferedReader.ready()) {
            String strLine = bufferedReader.readLine();
            String [] str = strLine.split("\\s");
            for (String st : str) {
                if (words.contains(st)) {
                    cx++;
                }
            }
            if (cx == 2) {
                System.out.println(strLine);
            }
            cx = 0;
        }
        bufferedReader.close();
    }
}
