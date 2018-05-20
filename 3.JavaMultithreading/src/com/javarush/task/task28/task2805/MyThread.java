package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger aInt = new AtomicInteger(0);
    private void init() { // блок инициализации
        aInt.incrementAndGet(); // увеличиваем счетчик
        aInt.compareAndSet(11, 1); // if (aInt == 11) aInt = 1;
        int tmpCx = aInt.get(); // создаем переменную чб учитывать переход с 11 на 1
        int maxPriority = getThreadGroup().getMaxPriority();
        if (tmpCx > maxPriority) { // это чтобы не выйти за границу приоритета группы
            tmpCx = maxPriority;
        }
        setPriority(tmpCx); // устанавливаем приоритет
    }

    public MyThread() {
        init();
    }

    public MyThread(Runnable target) {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        init();
    }

    public MyThread(String name) {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        init();
    }


    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        init();
    }

}
