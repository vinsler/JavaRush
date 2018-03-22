package com.javarush.task.task08.task0823;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import static jdk.nashorn.internal.objects.NativeString.trim;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = trim(reader.readLine());
        int z = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            {
                z = -1;
            }

            if (z == 0)
            {
                System.out.print(toUpperCase(s.charAt(i)));
            }
            else
            {
                System.out.print(s.charAt(i));
            }
            z++;
        }



        /*String fin ="";

        char[] chArray = s.toCharArray();
        String ns = "";

        for (int i = 0; i < chArray.length; i++) {

            if (chArray[i] != ' ') // если считываем символ чар не равен пробелу
            {
                if (ns.length() == 0) // если длинна ns равна ноль
                {
                    ns += chArray[i]; // добавляем к ns текущий символ
                    ns.toUpperCase(); // и поднимаем регистр вверх ns с одним символом, первым
                }
                else // если длинна ns не равна нулю
                {
                    ns += chArray[i]; // прибавляем к ns следующие символы
                }
            }
            else  // если считываемый символ чар равен пробелу, то выводим строку на экран и обнуляем ее
            {
                ns += chArray[i]; // добавляем пробел
                System.out.print(ns); // выводим на экран
                ns = ""; // обнуляем строку
            }
        }

        System.out.print(ns); // вывод последнего слова в строке */
    }
}