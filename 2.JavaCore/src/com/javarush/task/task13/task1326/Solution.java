package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader readerfile = new BufferedReader(new InputStreamReader(System.in));
        // для чтения с консоли имя файла в readerfile
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(readerfile.readLine())));
        readerfile.close();
        // конструкция для построчного чтения с консоли, но уже из файла, который мы в этой строке введем

        ArrayList <Integer> list = new ArrayList<Integer>(); // это новый список для записи значений
        String stmp = ""; // переменная строка для чтения строк из файла

        while ((stmp = reader.readLine()) != null) //  пока считываемая строка не null
        {
            if ((Integer.parseInt(stmp)) % 2 == 0)  // если эта строка переведенная в int четная
            {
                list.add(Integer.parseInt(stmp)); // добавляем ее в список
            }
        }

        reader.close();

        Collections.sort(list);

        for (int i : list)
        {
                System.out.println(i);
        }
    }
}
