package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        synchronized (mail) { // захватываем мютекс mail
            long beforeTime = System.currentTimeMillis();
            String name = Thread.currentThread().getName();
            try {
                mail.wait(); // засыпаем, освобождаем мютекс mail
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long afterTime = System.currentTimeMillis();
            System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
        }
    }
}
