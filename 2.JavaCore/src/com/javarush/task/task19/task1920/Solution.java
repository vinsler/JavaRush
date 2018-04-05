package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<String, Double>();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String str[] =  reader.readLine().split("\\s");
            if (map.containsKey(str[0])) {
                map.put(str[0], map.get(str[0]) + Double.parseDouble(str[1]));
            } else {
                map.put(str[0], Double.parseDouble(str[1]));
            }
        }
        reader.close();

        Double maxValue= 0.0;
        for (Map.Entry <String, Double> pair : map.entrySet()) {
            if (pair.getValue() > maxValue) {
                maxValue = pair.getValue();
            }
        }

        for (Map.Entry <String, Double> pair : map.entrySet()) {
            if (pair.getValue().equals(maxValue)) {
                System.out.println(pair.getKey());
            }
        }


    }
}
