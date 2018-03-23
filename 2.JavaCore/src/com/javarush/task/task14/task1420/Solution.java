package com.javarush.task.task14.task1420;

/*
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());

        if (i1 <= 0 || i2 <= 0)
        {
            throw new Exception();
        }

        if (i1 < i2)
        {
            int tmp = i1;
            i1 = i2;
            i2 = tmp;
        }

        int nod = 0;

        for (int i = 1; i < i1; i++)
        {
            if (i1 % i == 0 && i2 % i == 0 && i > nod)
            {
                nod = i;
            }
        }
        System.out.println(nod);
    }
}
