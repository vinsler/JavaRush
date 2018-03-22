package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        String[] arrStr = new String[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 8; i++) {
            arrStr[i] = reader.readLine();
        }
        
        for (int i = 9; i >= 0; i--){
            System.out.println(arrStr[i]);
        }

    
        
    }
}