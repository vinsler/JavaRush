package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

import java.util.Arrays;

public class Solution {
    public static void processThreads(Thread... threads) { // 1. Метод processThreads принимает аргументом массив нитей.
        for (Thread thread : threads) {
            switch (thread.getState()){ // 6. Метод processThreads должен использовать оператор switch.
                case NEW: { // 2. Если переданная нить не запущена, нужно ее запустить.
                    thread.start();
                    break;
                }
                case WAITING: { // 3. Если переданная нить находится в ожидании, нужно ее прервать.
                    thread.interrupt();
                    break;
                }
                case BLOCKED: { // 3. Если переданная нить находится в ожидании, нужно ее прервать.
                    thread.interrupt();
                    break;
                }
                case TIMED_WAITING: { // 3. Если переданная нить находится в ожидании, нужно ее прервать.
                    thread.interrupt();
                    break;
                }
                case RUNNABLE: { // 4. Если переданная нить работает, то нужно проверить маркер isInterrupted.
                    thread.isInterrupted();
                    break;
                }
                case TERMINATED: { //5. Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
                    System.out.println(thread.getPriority());
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}
