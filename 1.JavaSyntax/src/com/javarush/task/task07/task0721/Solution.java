package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int maximum;
        int minimum;
        
        int[] intArr = new int[20];

        for (int i = 0; i < intArr.length; i++)
        {
            intArr[i] = Integer.parseInt(reader.readLine());
        }
        
        maximum = intArr[0];
        minimum = intArr[0];
        
        for (int i = 0; i < intArr.length; i++)
        {
            if (maximum < intArr[i])
            {
                maximum = intArr[i];
            }
            
            if (minimum > intArr[i])
            {
                minimum = intArr[i];
            }
        }
        
        System.out.println(maximum);
        System.out.println(minimum);
    }
}
