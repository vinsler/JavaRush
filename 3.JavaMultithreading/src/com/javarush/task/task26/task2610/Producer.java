package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0; // счетчик какой-то хз зачем
            while (true) {
                queue.put(String.valueOf(i++)); // и заливаем в очередь строки парс инк счетчика :-/
                Thread.sleep(300); // спим и заново
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}