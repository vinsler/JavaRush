package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream vfileRead = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        // "c:/data.txt");

        TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();

        while (vfileRead.available() > 0) {
            int tmp = vfileRead.read(); // считали байт в tmp
            if (tmap.containsKey(tmp)) { // Если такой уже есть, то увеличили values + 1
                tmap.put(tmp, tmap.get(tmp) + 1);
            } else {
                tmap.put(tmp, 1); // Если такого нет, то положили один.

            }
        }
        vfileRead.close();

        int maxValue = 0, tkey = 0;

        do {
            maxValue = 0;
            tkey = 0;
            for (Map.Entry<Integer, Integer> pair : tmap.entrySet()) {
                if (maxValue < pair.getValue()) {
                    maxValue = pair.getValue();
                    tkey = pair.getKey();
                }
            }
            //for (int i = 0; i < maxValue; i++) {
                System.out.print(tkey + " ");
            //}
            tmap.remove(tkey, maxValue);
        }
        while (tmap.containsValue(maxValue));
    }
}

