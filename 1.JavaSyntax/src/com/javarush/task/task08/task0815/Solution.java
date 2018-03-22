package com.javarush.task.task08.task0815;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String> ();

        for (int i = 0; i < 10; i++)
        {
            map.put("Alex" + i, "vins" + i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        return Collections.frequency(map.values(), name);

        /*int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getKey() == name)
            {
                count++;
            }
        }
        return count;


                int num=0;
        for (String s: map.values()) {
            if (s==name) num++;
        }

        */
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        return map.containsKey(lastName) ? 1 : 0;

        /*int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            if (pair.getValue() == lastName)
            {
                count++;
            }
        }
        return count;

        int num=0;
        for (String s: map.keySet()) {
            if (s==lastName) num++;
        }

        */
    }

    public static void main(String[] args) {

    }
}
