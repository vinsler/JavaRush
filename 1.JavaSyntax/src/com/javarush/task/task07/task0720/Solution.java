package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int M = 0, N = 0;
        ArrayList<String> list = new ArrayList<String>();
        
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < N; i++)
        {
            list.add(reader.readLine());
        }
        
        for (int i = 0; i < M; M--)
        {
            list.add(list.get(i));
            list.remove(i);
        }
        
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
