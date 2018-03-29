package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countSymbol = 0;
        int countSpace = 0;
        double sootn = 0.00;
        FileInputStream fileInputStream = new FileInputStream(args[0]); // "c:/tmp/data.txt");//

        while (fileInputStream.available() > 0){
            countSymbol++;
            int readposition = fileInputStream.read();
            //System.out.println(readposition);
            if (readposition == 32){
                countSpace++;
            }
        }
        fileInputStream.close();

        sootn = countSpace*1.00 / countSymbol*1.00*100;//*100;
        /*int tmp = (int) sootn;
        sootn = (double) tmp / 100;*/

        //System.out.println("пробелов-" +countSpace + ", символов-" + countSymbol);
        System.out.println(String.format("%.2f", sootn));
    }
}
