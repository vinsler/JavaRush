package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap <String, Double> map = new TreeMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String str = reader.readLine();
            String sta[] = str.split("\\s");
            if (map.containsKey(sta[0])) {
                map.put(sta[0], map.get(sta[0]) + Double.parseDouble(sta[1]));
            } else {
                map.put(sta[0], Double.parseDouble(sta[1]));
            }
        }
        reader.close();

        for (Map.Entry <String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
