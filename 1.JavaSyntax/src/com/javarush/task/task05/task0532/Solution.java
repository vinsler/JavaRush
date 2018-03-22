package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i, max = 0, tmp = 0;
        
        while (true){ // бесконечный цикл
            i = Integer.parseInt(reader.readLine()); // присваиваем i введенное число
            if (i > 0) break; // если это число > 0 то выходим из этого цикла
        }
        
        tmp = i; // это счетчик для ввода количества чисел с консоли
        
        while (i > 0){ // пока i > 0
            int j = Integer.parseInt(reader.readLine()); // вводим число с консоли
            if (i == tmp) max = j; // max присваиваем первое введенное число
            if (max < j) max = j; // если max < введенного числа, то присваиваем ему введенное число
            i--; // уменьшаем цикл на -1
        }
        
    System.out.println(max); // выводим максимальное число
    }
}
