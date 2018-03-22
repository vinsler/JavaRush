package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        ArrayList<String> arrlst = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++)
        {
            arrlst.add(reader.readLine());
        }
        
        String stmp;
        
        for (int i = 0; i < 13; i++)
        {
            stmp = arrlst.get(4);
            arrlst.remove(4);
            arrlst.add(0, stmp);
        }
        
        for (int i = 0; i < 5; i++)
        {
            System.out.println(arrlst.get(i));
        }
        
        
        //напишите тут ваш код
    }
}
