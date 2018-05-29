package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                ShareItem item = this.queue.take();
                System.out.format("Processing %s%n", item.toString());
            }
        } catch (InterruptedException e) {
        }
    }
}
