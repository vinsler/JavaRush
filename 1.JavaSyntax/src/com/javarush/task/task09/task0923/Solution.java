package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static jdk.nashorn.internal.objects.NativeString.trim;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine(), stG = "", stS = "";

        for (int i = 0; i < str.length(); i++)
        {
            if (isVowel(str.charAt(i)))
            {
                stG += str.charAt(i) + " ";
            }
            else
            {
                if (str.charAt(i) != ' ')
                {
                    stS += str.charAt(i) + " ";
                }
            }
        }
        System.out.println(stG);
        System.out.println(stS);
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}