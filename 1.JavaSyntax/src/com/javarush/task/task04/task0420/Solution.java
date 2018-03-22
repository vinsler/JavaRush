package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sn1 = reader.readLine();
        int n1 = Integer.parseInt(sn1);
        
        String sn2 = reader.readLine();
        int n2 = Integer.parseInt(sn2);
        
        String sn3 = reader.readLine();
        int n3 = Integer.parseInt(sn3);
        
        if (n1 > n2)
        {
            int i = n2;
            n2 = n1;
            n1 = i;
        }
          if (n2 > n3)
        {
            int i = n3;
            n3 = n2;
            n2 = i;
        }
          if (n1 > n2)
        {
            int i = n2;
            n2 = n1;
            n1 = i;
        }
        
        System.out.println(n3 + " " + n2  + " " + n1);
      
        
    }

}
