package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов

http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
lvl=15&view&name=Amigo

http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
obj=3.14&name=Amigo
0123456789012345678

*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        reader.close();

        String sTmp = str.substring(str.indexOf("?") + 1, str.length());
        // обрезаем строку с символа следующего за ? и до длинны строки lvl=15&view&name=Amigo
        str = sTmp;
        int x = 0;

        while (true) // lvl=15&view&name=Amigo // view&name=Amigo // name=Amigo
        {
            int i = str.indexOf ("="); // записываем i индекс на знаке "="
            if (str.contains("&"))
            {
                int j = str.indexOf("&"); // записываем j индекс на знаке "&"
                if (i > j) { i = j;} // если & встречается раньше, то вписываем его
            }

            System.out.print(str.substring(0, i)); // строка от 0-(3-1) lvl
            // выводим строку с начала до знака "="или "&", i в функции равен (endIndex - 1)
            str = str.substring(str.indexOf("&") + 1, str.length()); // 7-(22-1) view&name=Amigo
            // обрезаем строку от знака (&+1) до конца строки
            if (!str.contains("&")) // если строка не содержит больше знака "=" то выходим
            {
                x++;
                if (x == 2)
                {
                    break;
                }
            }
            System.out.print(" "); // добавляем пробел между параметрами lvl_view_
        }

        str = sTmp;
        System.out.println(""); // переходим на сл строку

        while (true) {
            if (str.contains("obj")) {
                int i = str.indexOf("obj");
                if (str.indexOf("&") != 0) {
                    str = str.substring(str.indexOf("obj") + 4, str.indexOf("&"));
                } else {
                    str = str.substring(str.indexOf("obj") + 4, str.length());
                }
                try {
                    alert((double) Double.parseDouble(str));
                } catch (NumberFormatException e) {
                    alert(str);
                }
            }
            else
            {
                break;
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
