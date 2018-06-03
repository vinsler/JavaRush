package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        try {
            String strArgs = args[0], strIncorrect = "incorrect";
            for (int i = 2; i < 37; i++) {
                try {
                    BigInteger bigInteger = new BigInteger(strArgs, i);
                    strIncorrect = String.valueOf(i);
                    break;
                } catch (Exception e) {
                }
            }
            System.out.println(strIncorrect);
        } catch (Exception e) {
        }
    }
}