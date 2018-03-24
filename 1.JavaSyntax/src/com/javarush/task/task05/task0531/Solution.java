package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int min5 = min(a, b, c, d, e);
        
    
        System.out.println("Minimum = " + min5);
        
    }


    public static int min(int a, int b, int c, int d, int e) {
        int a1, a2, a3, a4;
        
        if (a > b) a1 = b;
        else a1 = a;
        
        if (c > d) a2 = d;
        else a2 = c;
        
        if (a1 > a2) a3 = a2;
        else a3 = a1;
        
        if (e > a3) a4 = a3;
        else a4 = e;
        
        return a4;
    }
    
}
