package com.javarush.task.task16.task1624;

/* 
Последовательные выполнения нитей
*/

public class Solution {

    public static MyThread t = new MyThread(); // создаем обьект t MyThread
    static String message = "inside main "; // строка "внутри главной"

    public static void main(String a[]) throws Exception { // основной блок главный
        t.start(); // запускаем нить t
        //t.join();
        for (int i = 0; i < 10; i++) { // создаем 10 нитей
            System.out.println(message + i); // выводим в консоль inside main + 0..9
            sleep(); // вызываем sleep = Thread.sleep(10)
        }
    }

    public static void sleep() { // сон на 10 милисекунд
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    static class MyThread extends Thread { // создаем класс MyThread - нить
        String message = "inside MyThread "; // строка inside MyThread

        public void run() { // при создании обьекта запускаем бег
            for (int i = 0; i < 10; i++) { // для цикла из 10
                System.out.println(message + i); // выводим строка inside MyThread + 0..9
                Solution.sleep(); // вызываем sleep = Thread.sleep(10)
            }
        }
    }
}