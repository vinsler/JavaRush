package com.javarush.task.task10.task1019;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String id = "";
        String name = "";

        while (true)

        {
            id = reader.readLine();

            if (id.isEmpty())
            {
                break;
            }

            name = reader.readLine();

            map.put(name, Integer.parseInt(id));
        }

        for (Map.Entry pair : map.entrySet())

        {
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
