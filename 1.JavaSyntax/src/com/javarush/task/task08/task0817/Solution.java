package com.javarush.task.task08.task0817;


import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {

    public static HashMap<String, String> createMap() {

        HashMap<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 10; i++)
        {
            map.put("Ale" + i, "Koo" + i);
        }
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {

            ArrayList<String> names = new ArrayList<>();

            for (Map.Entry<String, String> pair : map.entrySet()) {
                int n = Collections.frequency(map.values(), pair.getValue());
                if (n > 1) names.add(pair.getValue());
            }

            for (int i = 0; i < names.size(); i++) {
                removeItemFromMapByValue(map, names.get(i));
            }
            //напишите тут ваш код
        }



    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {

        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : copy.entrySet()) {

            if (pair.getValue().equals(value))

                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
