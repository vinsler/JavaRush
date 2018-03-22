package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrLst = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++)
        {
            arrLst.add(reader.readLine());
        }
        
        int sks = arrLst.get(0).length();
        
        for (int i = 0; i < 5; i++)
        {
            if (arrLst.get(i).length() < sks ) sks = arrLst.get(i).length();
        }
        
        for (int i = 0; i < 5; i++)
        {
            if (arrLst.get(i).length() == sks) System.out.println(arrLst.get(i));
        }
        
        
    }
}
