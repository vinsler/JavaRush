package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }



        for (int i = 0; i < alphabet.size(); i++) // alphabet array
        {
            int count = 0;
            for (int j = 0; j < list.size(); j++) // strings list
            {
                for (int k = 0; k < list.get(j).length(); k++) // by length string from list
                {
                    if (list.get(j).charAt(k) == alphabet.get(i))
                    {
                        count++;
                    }
                }
            }
            System.out.println(alphabet.get(i) + " " + count);
            count = 0;
        }

        /*

        for (int i = 0; i < list.size(); i++) // Цикл по всему листу из строк
        {
            for (int j = 0; j < alphabet.size(); j++) // Цикл по всему массиву из char алфавита
            {
                int count = 0; // счетчик равен нулю

                for (int k = 0; k < list.get(i).length(); k++)  // проход по длинне каждой строки
                {
                    if (list.get(i).charAt(k) == alphabet.get(j)) // если символ строки равен букве из алфавита
                    {
                        count++; // то плюсуем счетчик
                    }

                    if (k == list.get(i).length() - 1) // если идет последний цикл, то выводим букву и счетчик
                    {
                        System.out.println(alphabet.get(j) + " " + count);
                    }
                }

                count = 0; // обнуляем счетчик для следующей буквы
            }
        }*/




        // напишите тут ваш код
    }

}
