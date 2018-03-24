package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        do
        {
        int j = 0;
        
            for (int x = i; x > 0; x--)
            j = j + x;
            
        System.out.println(j);
        i++;
        }
        while (i < 11);
    }
}
