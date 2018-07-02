package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < 8; i++) {
            Random r = new Random();
            char chToUp = (char)(r.nextInt(26) + 'a');
            String strToUp = String.valueOf(chToUp).toUpperCase();
            int intRnd = r.nextInt(9);
            char chToLow = (char)(r.nextInt(26) + 'a');

            int forCase = r.nextInt(3);

            try {
                if (i == 0) {
                    baos.write(strToUp.getBytes());
                    continue;
                }
                if (i == 1) {
                    baos.write(String.valueOf(intRnd).getBytes());
                    continue;
                }
                if (i == 3) {
                    baos.write(chToLow);
                    continue;
                }
                if (forCase == 0) {
                    baos.write(strToUp.getBytes());
                } else if (forCase == 1) {
                    baos.write(String.valueOf(intRnd).getBytes());
                } else {
                    baos.write(chToLow);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return baos;
    }
}