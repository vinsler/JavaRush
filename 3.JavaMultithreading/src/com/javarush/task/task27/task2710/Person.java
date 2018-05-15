package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (mail) { // захватываем мютекс mail
            mail.setText("Person [" + name + "] has written an email 'AAA'");
            mail.notify(); // пробуждаем нить, она заработает, после того как mail освободится
        }
    }
}
