package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        int[] arrInt20 = new int[20];
        int[] arrInt10_1 = new int[10];
        int[] arrInt10_2 = new int[10];
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 20; i++)
        {
            arrInt20[i] = Integer.parseInt(reader.readLine());
            
            if (i < 10)
            {
                arrInt10_1[i] = arrInt20[i];
            }
            else 
            {
                arrInt10_2[i-10] = arrInt20[i];
                System.out.println(arrInt10_2[i-10]);
            }
            
        }
        
        //напишите тут ваш код
    }
}
