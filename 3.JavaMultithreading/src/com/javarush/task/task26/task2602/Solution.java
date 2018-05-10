package com.javarush.task.task26.task2602;

import java.util.Set;
import java.util.TreeSet;

/* 
Был бы ум - будет и успех
*/
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Sidorov0", 175));
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov1", 175));
        soldiers.add(new Soldier("Sidorov2", 175));

        // один хрен не добавит он одинаковые значения, странно ведь ключ это имя, а они все разные.

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
            System.out.println(soldier.height);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }
        //Comparator<Soldier> comp = (Soldier h1, Soldier h2) -> h2.height - h1.height; // это не хочет

        @Override
        public int compareTo(Soldier s) {
            //Soldier s = (Soldier) o; // так не принимает
            //return Integer.compare(s.height - this.height); // так тоже
            System.out.println(s.height + " : " + this.height);
            return s.height - this.height;
        }

    }
    }

