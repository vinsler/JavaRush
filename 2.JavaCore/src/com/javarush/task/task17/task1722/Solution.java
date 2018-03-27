package com.javarush.task.task17.task1722;

/* 
Посчитаем
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // 5. Метод main(String[] args) класса Solution не должен использовать Thread.sleep().

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        // 6. Для каждой нити, в методе main(String[] args) класса Solution используй метод, который ожидает завершение нити.
        counter1.start();
        counter1.join();
        counter2.start();
        counter2.join();
        counter3.start();
        counter3.join();
        counter4.start();
        counter4.join();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    // 1. Класс Solution должен содержать класс Counter.
    // 2. Класс Counter должен быть нитью.
    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                // 3. Метод run() класса Counter должен содержать synchronized блок.
                // 4. Synchronized блок метода run() не должен блокировать мьютекс this.

                synchronized (Solution.class) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}
