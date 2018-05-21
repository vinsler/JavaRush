package com.javarush.task.task28.task2807;

import java.util.concurrent.*;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    private static volatile int id = 1;
    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue <Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 10 ; i++) {
            linkedBlockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(id++);
                }
            });
        }
        ThreadPoolExecutor service = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, linkedBlockingQueue);
        service.prestartAllCoreThreads();
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
