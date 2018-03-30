package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        // 1. Считывать с консоли ничего не нужно.
        // 2. Создай поток для чтения из файла, который приходит первым параметром в main.
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        //3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while (fileInputStream.available() > 0){
            int i = fileInputStream.read();
            if (map.containsKey(i)) {
                map.put(i , map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        fileInputStream.close();

        for (Map.Entry pair : map.entrySet()){
            /*String st = pair.getKey().toString();
            int i = Integer.parseInt(st);
            char ch = (char) i;*/
            char ch = (char) Integer.parseInt(pair.getKey().toString());
            System.out.println(ch +" " + pair.getValue());
        }
    }
}
