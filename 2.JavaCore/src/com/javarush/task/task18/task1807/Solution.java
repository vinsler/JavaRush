package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream filereader = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int cx = 0;
        while (filereader.available() > 0){
            if (filereader.read() == 44){
                cx++;
            }
        }
        filereader.close();
        System.out.println(cx);
    }
}
