package com.javarush.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
void shutdown()
Вызывает упорядоченное завершение работы, в котором выполняются ранее поставленные задачи,
но новые задачи не будут приняты.
List<Runnable> shutdownNow()
Попытка остановить все активное выполнение задач, приостанавливает обработку ожидающих задач
и возвращает список задач, ожидающих выполнения.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> list = executor.shutdownNow();
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
