package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int [] mass = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 20; i++)
        mass[i] = Integer.parseInt(reader.readLine());
        
        return mass;
    }

    public static int max(int[] array) {
        int max2 = array[0];
        for (int i = 0; i < 20; i++)
        {
            if (array[i] > max2) max2 = array[i];
        }

        return max2;
    }
}
