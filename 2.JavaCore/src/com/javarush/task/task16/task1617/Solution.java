package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

import static com.javarush.task.task16.task1617.Solution.countSeconds;

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();

        if (countSeconds == 3){
                clock.join();
                System.out.print("Марш!");
            }
            else if (countSeconds == 4) {
                clock.join();
                System.out.print("Прервано!");
            }
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            while (!(countSeconds == 0)){
                try {
                    Thread.sleep(1000);
                    System.out.print(countSeconds + " ");
                    countSeconds--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
