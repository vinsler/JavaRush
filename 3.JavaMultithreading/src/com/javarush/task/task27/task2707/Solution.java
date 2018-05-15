package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    private void blockO1(Object obj1) {
        synchronized (obj1) { // блочим о1
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        }
    }

    private void blockO2(Object obj2) {
        synchronized (obj2) { // блочим о2
            try {
                Thread.sleep(5);
            } catch (Exception e) {}
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        Thread thread1 = new Thread(new Runnable() { // поток для блока о1
            @Override
            public void run() {
                solution.blockO1(o1);
            }
        });

        Thread thread2 = new Thread(new Runnable() { // поток для блока о2
            @Override
            public void run() {
                solution.blockO2(o2);
            }
        });

        thread1.start(); // блочим о2
        Thread.sleep(100);
        System.out.println(thread1.getName() + " " + thread1.getState());
        thread.start(); // пускаем наш метод, он проходит до о1 или до о2
        Thread.sleep(100);
        System.out.println(thread.getName() + " " + thread.getState());
        thread2.start(); // блочим о1
        Thread.sleep(100);
        if (thread2.getState().equals(Thread.State.TERMINATED)) { //
            System.out.println(thread2.getName() + " " + thread2.getState());
            return true;
        } else {
            System.out.println(thread2.getName() + " " + thread2.getState());
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
