package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static class AmigoThreadFactory  implements ThreadFactory {
        AtomicInteger A = new AtomicInteger(0);
        AtomicInteger B = new AtomicInteger(0);
        static AtomicInteger tmp = new AtomicInteger(0);

        public AmigoThreadFactory() { // конструктор, первый раз установит 1, второй раз 2
            A.set(tmp.incrementAndGet());
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setPriority(Thread.NORM_PRIORITY);
            thread.setDaemon(false);
            thread.setName(Thread.currentThread().getThreadGroup().getName() + "-pool-" + A + "-thread-" + B.incrementAndGet());
            return thread;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask()); // 1 обьект AmigoThreadFactory

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask()); // 2 обьект AmigoThreadFactory

        thread.start(); // запускаем первую группу
        thread2.start(); // запускаем вторую группу
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory(); // создаем обьект AmigoThreadFactory
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start(); // запускаем 1 нить, метод из AmigoThreadFactory, увеличиваем счетчик нити
        factory.newThread(r).start(); // запускаем 2 нить, -//-
        factory.newThread(r).start(); // запускаем 3 нить, -//-
    }
}
