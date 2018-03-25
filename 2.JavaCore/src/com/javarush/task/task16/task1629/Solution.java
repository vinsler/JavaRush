package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {

        Read3Strings t1 = new Read3Strings();  // создали объект типа нить
        //t1.start(); // запустили нить
        t1.join(); // подождал пока закончится нить

        Read3Strings t2 = new Read3Strings(); // создали следующий обьект типа нить
        //t2.start(); // запустили нить
        t2.join(); // подождали пока закончится нить

        t1.printResult(); // вывели строку от 1 нити
        t2.printResult(); // вывели строку от 2 нити

    }

    public static class Read3Strings extends Thread
    {
        public String str = ""; // создали строку для ввода

        public void printResult() // метод для вывода строки
        {
            System.out.println(str);
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            //for (int i = 0; i < 3; i++)
            //{
                try {
                    str = reader.readLine() + " " + reader.readLine() + " " + reader.readLine();
                    // скомпоновали 3 введенных строки в одну с пробелами
                } catch (IOException e) {
                    e.printStackTrace();
                }
            //}
            super.run(); // запустили нить.
        }



    }
}
