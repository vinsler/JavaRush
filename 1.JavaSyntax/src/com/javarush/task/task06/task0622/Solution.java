package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        int a4 = Integer.parseInt(reader.readLine());
        int a5 = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < 5; i++)
        {
        if (a1 > a2)
        {
            int z = a2;
            a2 = a1;
            a1 = z;
        }
        
        if (a2 > a3)
        {
            int z = a3;
            a3 = a2;
            a2 = z;
        }

         if (a3 > a4)
        {
            int z = a4;
            a4 = a3;
            a3 = z;
        }
         if (a4 > a5)
        {
            int z = a5;
            a5 = a4;
            a4 = z;
        }
        }
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);




        //напишите тут ваш код
    }

}
