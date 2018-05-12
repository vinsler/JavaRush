package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer (BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) { // а тут нам нужно вытащить из очереди эти строки
                System.out.println(queue.poll().toString()); // ну читаем ее и выводим типа :-/ и чо?
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
