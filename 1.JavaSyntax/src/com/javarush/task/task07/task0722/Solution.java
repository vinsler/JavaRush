package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<String> list = new ArrayList<String>();
        String str;
        
        do
        {
            str = reader.readLine(); // вводим строку
            
            if (str.equals("end")) // если строка == end
                break;   // выходим из цикла
            else // если строка != end
                list.add(str); // добавляем строку в список
        }
        while (true); // бесконечный цикл
        
        for (int i = 0; i < list.size(); i++) // пока размер списка не больше int
        {
            System.out.println(list.get(i)); // выводим на экран с новой строки элемент списка i
        }
    }
}