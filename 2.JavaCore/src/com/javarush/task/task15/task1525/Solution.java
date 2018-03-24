package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution
{
    public static List<String> lines = new ArrayList<String>();

    static
    {
        String step;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(Statics.FILE_NAME)));

            while ((step = reader.readLine()) != null) //  пока считываемая строка не null
            {
                lines.add(step); // добавляем ее в список
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        System.out.println(lines);
    }
}
