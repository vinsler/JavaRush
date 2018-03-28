package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream fread = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        int maxb = 0;

        while (fread.available() > 0){
            int tmp = fread.read();
            if ( tmp  > maxb) maxb = tmp;
        }
        fread.close();

        System.out.println(maxb);
    }
}
