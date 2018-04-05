package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static
    {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
// c:/tmp/1.txt

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String strLine = bufferedReader.readLine();
            Pattern pattern = Pattern.compile("\\b[0-9]\\b|\\b1[0-2]\\b");
            Matcher matcher = pattern.matcher(strLine);

            while (matcher.find()) {
                int j = Integer.parseInt(matcher.group());

                for (Map.Entry pair : map.entrySet())
                {
                    if (pair.getKey().equals(j)) {
                        strLine = strLine.replaceAll("\\b" + j + "\\b", pair.getValue().toString());
                    }
                }
            }
            System.out.println(strLine);
        }
        bufferedReader.close();
    }
}
