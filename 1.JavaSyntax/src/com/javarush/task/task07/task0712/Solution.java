package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> arrlst = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++)
        {
            arrlst.add(reader.readLine());
        }
        
        int max = arrlst.get(0).length(), min = arrlst.get(0).length();
        
        for (int i = 0; i < 10; i++)
        {
            if (max < arrlst.get(i).length()) max = arrlst.get(i).length();
            if (min > arrlst.get(i).length()) min = arrlst.get(i).length();
        }
        
        for (int i = 0; i < 10; i++)
        {
            if ((arrlst.get(i).length() == max)||(arrlst.get(i).length() == min))
            {
                System.out.println(arrlst.get(i));
                break;
            }
        }
        
        
    }
}
