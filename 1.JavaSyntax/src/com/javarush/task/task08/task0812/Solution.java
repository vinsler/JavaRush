package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> list = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)
        {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int a1 = 1, max = 0;

        for (int i = 0; i < 9; i++)
        {
            if (list.get(i) == list.get(i + 1))
            {
                a1++;
            }
            else
            {
                a1 = 1;
            }

            if (a1 > max)
                {
                    max = a1;
                }
        }
        System.out.println(max);
    }
}