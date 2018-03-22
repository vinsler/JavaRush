package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("kurb1a", 100);
        map.put("kurb2a", 200);
        map.put("kurb3a", 300);
        map.put("kurb4a", 400);
        map.put("kurb5a", 500);
        map.put("kurb6a", 6000);
        map.put("kurb7a", 7000);
        map.put("kurb8a", 8000);
        map.put("kurb9a", 9000);
        map.put("kurb10a", 5000);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {

        Iterator <Map.Entry<String, Integer>> entries = map.entrySet().iterator();
        // Iterator - тип перменной типа <Map.Entry<String, String>>
        // создаем переменную типа Iterator и называем ее entries
        // присваиваем ей значение всех множеств пар из map ALL.K-V

        while (entries.hasNext()) // пока все множества пар не закончились
        {
            Map.Entry<String, Integer> entry = entries.next();
            // Map.Entry - тип переменной одного поля K-V
            // создаем переменную - entry
            // и присваиваем ей значение следующего next из всех множеств;

            if (entry.getValue() < 500) // если зп меньше 500 в значении getValue полученного одного поля
            {
                entries.remove(); // то берем все множество, и удаляем поле, на котором сейчас установлен итератор
            }
        }
    }

    public static void main(String[] args) {

    }
}