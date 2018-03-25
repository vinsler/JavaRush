package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame(); // создаем нить
        onlineGame.start(); // запускаем нить
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>(); // список 4 строк (просто)

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3); // создаем обьект нить 1
        protected Gamer gamer2 = new Gamer("Petrov", 1); // создаем обьект нить 2
        protected Gamer gamer3 = new Gamer("Sidorov", 5); // создаем обьект нить 3

        public void run() {
            gamer1.start(); // запускаем нити
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) { // пока нет победителя прерываем нити
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < OnlineGame.steps.size(); i++)
            {
                System.out.println(getName() + ":" + OnlineGame.steps.get(i));

                try
                {
                    Thread.sleep(1000 / rating);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    System.out.println(getName() + ":"+"проиграл!");
                }

            }

            if (OnlineGame.isWinnerFound == false)
            {
                OnlineGame.isWinnerFound = true;
                System.out.println(getName() + ":" + "победитель!");
            }
        }
    }
}
