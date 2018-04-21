package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");

    }
    public static String [] getTokens(String query, String delimiter) {
        int i = 0;
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String [] strArr = new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()) {
            strArr[i] = tokenizer.nextToken();
            i++;
        }
        return strArr;

       /* while (tokenizer.hasMoreTokens()) {
            if (i == 0) {
                strArr[i] = String.format("\"%s\",", tokenizer.nextToken());
            } else if (i == strArr.length - 1) {
                strArr[i] = String.format(" \"%s\"", tokenizer.nextToken());
            } else {
                strArr[i] = String.format(" \"%s\",", tokenizer.nextToken());
            }
            System.out.print(strArr[i]);
            i++;
        }
        return strArr;*/
    }
}
