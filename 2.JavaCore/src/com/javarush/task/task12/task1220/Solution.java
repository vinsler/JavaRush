package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы Run, Swim
*/

public class Solution {

    public static void main(String[] args) {

    }

    public interface Run
    {
        public void getrun();
    }

    public interface Swim
    {
        public void getSwim();
    }


    public abstract class Human implements Run, Swim
    {
/*
        public void getrun() {
        }

        public void getSwim() {

        }
        */
    }






}
