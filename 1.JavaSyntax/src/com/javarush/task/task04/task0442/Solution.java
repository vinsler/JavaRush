package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // открываем поток для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // определяем переменные
        int count = 0, i = 0;
        
        while (true) // бесконечный цикл
        {
            i = Integer.parseInt(reader.readLine()); // присваиваем i введенное число
            if  (i == -1) // если это число == -1
            {
                System.out.println(count - 1); // выход если введено -1, отнимаем из count
                break;
            }
            count += i; // суммирование в count введенного числа если это не -1
        }
    }
}
