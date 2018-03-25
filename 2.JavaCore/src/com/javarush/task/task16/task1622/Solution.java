package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
*/

import sun.awt.windows.ThemeReader;

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < COUNT; i++) {
            new SleepingThread().join(); // создаем обьект идем в класс
            //SleepingThread.currentThread().join();
            //Thread.currentThread().join();
        }
    }

    public static class SleepingThread extends Thread { // приходим в класс
        private static volatile int threadCount = 0;
        private volatile int countDownIndex = COUNT;

        public SleepingThread() { // коснтруктор Thread.String.{valueOf(++threadCount)}==0..X
            super(String.valueOf(++threadCount));
            start(); // стартуем нить
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDownIndex == 0) return;
                //напишите тут ваш код
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Нить прервана");
                }
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}
