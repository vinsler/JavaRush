package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args)  {

        Human man1 = new Human("misa", false, 12, null);
        Human man2 = new Human("mita", false, 13, null);
        Human wman1 = new Human("nast", true, 7, null);

        ArrayList<Human> child = new ArrayList<>();
        child.add(man1);
        child.add(man2);
        child.add(wman1);

        Human papa = new Human("lesha", false, 41, child);
        Human mama = new Human("masha", true, 38, child);

        ArrayList<Human> mpapa = new ArrayList<>();
        mpapa.add(mama);

        ArrayList<Human> ppapa = new ArrayList<>();
        ppapa.add(papa);

        Human ded1 = new Human("slav", false, 71, mpapa);
        Human ded2 = new Human("vova", false, 87, ppapa);

        Human baba1 = new Human("laris", true, 75, mpapa);
        Human baba2 = new Human("galya", true, 88, ppapa);

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(wman1);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        /*
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }*/

        public Human(String name, boolean sex, int age, ArrayList <Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
