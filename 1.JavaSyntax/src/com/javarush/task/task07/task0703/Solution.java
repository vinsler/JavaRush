package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] arrString = new String[10];
        int[] arrInt = new int[10];
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++)
        {
            arrString[i] = reader.readLine();
            
            System.out.println(arrString[i].length());
        }
        
        //напишите тут ваш код
    }
}
