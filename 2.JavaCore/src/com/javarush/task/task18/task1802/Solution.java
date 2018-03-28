package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream freader = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        int min = 1000;

        while (freader.available() > 0){
            int tmp = freader.read();
            if ( min > tmp)
                min = tmp;

        }

        freader.close();

        System.out.println(min);
    }

}
