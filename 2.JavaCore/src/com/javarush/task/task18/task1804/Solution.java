package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Map;
import java.util.TreeMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream fileReader = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        // "c:/data.txt");
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        while (fileReader.available() > 0)
        {
            int fr = fileReader.read();

            if (treeMap.containsKey(fr)){
                treeMap.put(fr, treeMap.get(fr) + 1);
            }
            else {
                treeMap.put(fr, 1);
            }
            //System.out.println(treeMap.keySet() + " " + treeMap.values());
        }
        fileReader.close();

        int minvalue = 256;

        for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()){
            if (pair.getValue() < minvalue) minvalue = pair.getValue();
        }

        for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()){
            if (pair.getValue() == minvalue){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
