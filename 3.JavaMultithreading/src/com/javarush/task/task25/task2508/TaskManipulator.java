package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    // 4. Метод start должен создавать, сохранять во внутреннее поле
    // и запускать нить с именем, которое передано через аргумент метода.
    @Override
    public void start(String threadName) {
        //Thread thread = new Thread(this, threadName);
        Thread thread = new Thread(this);
        thread.setName(threadName);
        this.thread = thread;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
