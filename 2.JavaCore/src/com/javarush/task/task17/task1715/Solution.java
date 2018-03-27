package com.javarush.task.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Аптека
*/

public class Solution {

    //1. Класс Solution должен содержать public static поле drugsController типа DrugsController.
    public static DrugsController drugsController = new DrugsController();

    //2. Класс Solution должен содержать public static поле isStopped типа boolean.
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    //4. Класс Apteka должен реализовывать интерфейс Runnable.
    public static class Apteka implements Runnable {
        // 5. Нить Apteka должна работать пока isStopped = false.
        // 6. Нить Apteka должна использовать drugsController для закупки
        // случайного лекарства (getRandomDrug) в количестве (getRandomCount)
        // 7. Нить Apteka должна ждать 300мс + "между закупками", используя метод waitAMoment().
        public void run() {
            while (!isStopped) {
                drugsController.buy(getRandomDrug(), getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static class Person implements Runnable {
        // 9. Нить Person должна работать пока isStopped = false.
        // 10. Нить Person должна использовать drugsController для продажи
        // случайного лекарства (getRandomDrug) в количестве (getRandomCount).
        // 11. Нить Person должна ждать 100мс + "между закупками", используя метод waitAMoment().
        public void run() {
            while (!isStopped) {
                drugsController.sell(getRandomDrug(), getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static int getRandomCount() { // возвращает радном int i = getRandomDrug();
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        //3. Класс Solution должен содержать private static void метод waitAMoment(),
        // который должен ждать 100 мс
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
