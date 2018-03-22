package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b = (byte) a + 46; // 46
        byte c = (byte) (a * b); // 0
        double f = (int) 1234.15; // 1234
        long d = (char) (a + f / c + b); //  0 + 1234 делить на 46
        System.out.println(d);
    }
}
