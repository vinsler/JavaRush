package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private boolean sex;
        private String work;
        private String obrazov;
        private int height;

        public Human(String name)
        {
            name = this.name;
        }

        public Human(String name, int age)
        {
            name = this.name;
            age = this.age;
        }

        public Human(String name, int age, boolean sex)
        {
            name = this.name;
            age = this.age;
            sex = this.sex;
        }

        public Human(String name, int age, boolean sex, String work, String obrazov)
        {
            name = this.name;
            age = this.age;
            sex = this.sex;
            work = this.work;
            obrazov = this.obrazov;
        }

        public Human(String name, int age, boolean sex, String work, String obrazov, int height)
        {
            name = this.name;
            age = this.age;
            sex = this.sex;
            work = this.work;
            obrazov = this.obrazov;
            height = this.height;
        }

        // ===================================================================================
        public Human(String name, int age, boolean sex, String work, int height)
        {
            name = this.name;
            age = this.age;
            sex = this.sex;
            work = this.work;
            height = this.height;
        }

        public Human(String name, boolean sex, String work, String obrazov, int height)
        {
            name = this.name;
            sex = this.sex;
            work = this.work;
            obrazov = this.obrazov;
            height = this.height;
        }

        public Human(int age, boolean sex, String work, String obrazov, int height)
        {
            age = this.age;
            sex = this.sex;
            work = this.work;
            obrazov = this.obrazov;
            height = this.height;
        }

        public Human(String name, int age, String work, String obrazov, int height)
        {
            name = this.name;
            age = this.age;
            work = this.work;
            obrazov = this.obrazov;
            height = this.height;
        }

        public Human(String name, int age, boolean sex, int height)
        {
            name = this.name;
            age = this.age;
            sex = this.sex;
            height = this.height;
        }
    }
}
