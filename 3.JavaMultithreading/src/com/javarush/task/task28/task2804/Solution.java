package com.javarush.task.task28.task2804;

import java.util.List;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/* 
Magic class
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        List<String> list = new CopyOnWriteArrayList<>(); // Вывод правда все-равно не правильный, но ничего. )))

        solution.startUpdatingThread(list);
        solution.copyOnWriteSolution(list);
        solution.stopUpdatingThread();
    }

    public void copyOnWriteSolution(List<String> list) throws InterruptedException {
        System.out.println("size = " + list.size());
        System.out.println();
        Thread.sleep(20);
        for (String element : list) {   //создает новую копию на момент создания итератора
            System.out.println("Element :" + element);
        }
        System.out.println("size = " + list.size());
        System.out.println();
        Thread.sleep(20);

        for (String element : list) {  //создает новую копию на момент создания итератора
            System.out.println("Element2 :" + element);
        }
        System.out.println("size = " + list.size());
        stopUpdatingThread();
    }

    public void stopUpdatingThread() throws InterruptedException {
        t.stop();
        t.join();
    }

    private Thread t;

    private void startUpdatingThread(final List<String> list) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    list.add("s" + ThreadLocalRandom.current().nextInt());
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        t.start();
    }
}
