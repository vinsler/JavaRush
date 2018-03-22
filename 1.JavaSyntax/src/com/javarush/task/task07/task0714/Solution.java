package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> lStr = new ArrayList<String>();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++)
        {
            lStr.add(reader.readLine());
        }
        
        lStr.remove(2);
        
        for (int i = 3; i >= 0; i--)
        {
            System.out.println(lStr.get(i));
        }
       
    }
}


