package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)

    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (String s : list) // for (string s = 0 position; s position < list.size; s position ++)
        {
            if (result.get(s) != null) // if string found in result.hashmap
            {
                result.put(s, result.get(s) + 1); // put string & +1 for value by key
            }
            else
            {
                result.put(s,1); // if not found, put value 1
            }
        }
        return result;



        /*int bb = 0;

        for (int i = 0; i < list.size(); i++) //  первую строку сравниваем
        {
            for (int j = 0; j < list.size(); j++) // со всеми строками
            {
                if ((list.get(i) == list.get(j)) && (!result.containsKey(list.get(i))))
                {
                    bb++;
                }
            }

            if (bb != 0)
            {
                result.put(list.get(i), bb + 1);
            }

            bb = 0;

        }
        */


        //напишите тут ваш код


    }

}

