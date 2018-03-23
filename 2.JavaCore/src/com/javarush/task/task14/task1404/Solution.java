package com.javarush.task.task14.task1404;

/* 
Коты
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception

    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String str = reader.readLine();
            if (str.isEmpty())
            {
                break;
            }
            list.add(str);
        }
        reader.close();

        for (String s : list)
        {
            Cat cat = CatFactory.getCatByKey(s);
            System.out.println(cat.toString());
        }


        //напишите тут ваш код getCatByKey(s)

    }

    static class CatFactory
    {
        static Cat getCatByKey(String key)
        {
            Cat cat = null;
            if ("vaska".equals(key))
            {
                cat = new MaleCat("Василий");
            }

            else if ("murka".equals(key))
            {
                cat = new FemaleCat("Мурочка");
            }

            else if ("kiska".equals(key))
            {
                cat = new FemaleCat("Кисюлька");
            }

            else
                {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat
    {
        private String name;

        protected Cat(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return this.name;
        }

        public String toString()
        {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat
    {
        MaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat
    {
        FemaleCat(String name)
        {
            super(name);
        }

        public String toString()
        {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
