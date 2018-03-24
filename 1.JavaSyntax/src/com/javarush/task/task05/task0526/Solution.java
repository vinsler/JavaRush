package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("vasya",23, "on 22");
        Man man2 = new Man("petya",21, "on 2");
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        Woman woman1 = new Woman("katya", 28, "asrdasd22");
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        Woman woman2 = new Woman("nastya", 19, "assd452");
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);
    }
    
    
    public static class Man {
        public String name, address;
        public int age;
        
        public Man(String name, int age, String address)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }
    public static class Woman {
        public String name, address;
        public int age;
        
        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }

    //напишите тут ваш код
}
