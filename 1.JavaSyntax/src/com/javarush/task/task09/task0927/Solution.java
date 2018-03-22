package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {

        Cat[] kot = new Cat[10];

        for (int i = 0; i < 10; i++)
        {
            kot[i] = new Cat("kotyara" + i);
        }

        HashMap<String, Cat> catHmap = new HashMap<String, Cat>();
        for (int i = 0; i < 10; i++)
        {
            catHmap.put(kot[i].toString(), kot[i]);
        }


        return catHmap;
    }


        public static Set<Cat> convertMapToSet(Map<String, Cat> map) {


            Set<Cat> Seet = new HashSet();

            for (Map.Entry<String, Cat> p : map.entrySet())
            {
                Seet.add(p.getValue());
            }

            return Seet;
        }


        


    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
