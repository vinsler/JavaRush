package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {

        ArrayList<String>[] list = new ArrayList[]{new ArrayList<String>(),new ArrayList<String>()};

        // создать массив типа ArrayList<String>[] назовем его list, создадим обьект new ArrayList[]
        // в котором создадим 2 массива строк {new ArrayList<String>(),new ArrayList<String>()}

        list[0].add("Example1");
        list[1].add("Example2");

        return list;

    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}