package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args)  {
        System.out.println(getPartOfString("JavaRush - лучший сервисобученияJava."));
    }

    public static String getPartOfString(String string) {

        try {
            String[] strArr = string.split(" ");
            return String.format("%s %s %s %s", strArr[1], strArr[2], strArr[3], strArr[4]);
        } catch (Exception e) {
            throw new TooShortStringException();
        }


        /*String [] strArr = string.split(" ");
        if (strArr.length < 5) throw new TooShortStringException();
        return String.format("%s %s %s %s", strArr[1], strArr[2], strArr[3], strArr[4]);*/


        /*int cxSpace = 0;
        for (int i = 0; i < string.length() ; i++) {
            if (string.charAt(i) == ' ') {
                cxSpace++;
                if (cxSpace == 5) {
                    cxSpace = i;
                    break;
                }
            }
            if (i == (string.length() - 1)) {
                if (cxSpace < 4) throw new TooShortStringException();
                cxSpace = string.length();
            }
        }
        return string.substring(string.indexOf(" ") + 1, cxSpace);*/
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException() {
            super();
        }
    }
}
