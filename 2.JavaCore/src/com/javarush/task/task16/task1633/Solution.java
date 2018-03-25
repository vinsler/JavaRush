package com.javarush.task.task16.task1633;

public class Solution
{
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();
    // создаем handler типа Thread.UncaughtExceptionHandler
    // и выделяем под него обьем памяти размером OurUncaughtExceptionHandler

    public static void main(String[] args) // основной блок
    {
        TestedThread commonThread = new TestedThread(handler);
        // создаем commonThread типа TestedThread и такой же обьем памяти

        Thread threadA = new Thread(commonThread, "Нить 1"); // создали нитьА Thread
        Thread threadB = new Thread(commonThread, "Нить 2"); // создали нитьВ Thread

        threadA.start(); // запустили нитьА
        threadB.start(); // запустили нитьВ

        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.interrupt();  // прервали нитьА
        threadB.interrupt();  // прервали нитьВ
    }

    public static class TestedThread extends Thread // описание класса TestedThread
    {
        public TestedThread(Thread.UncaughtExceptionHandler handler)
        // конструктор с параметром Thread.UncaughtExceptionHandler
        {
            setUncaughtExceptionHandler(handler);
            // устанавливаем значение переданное в конструктор
            start(); // запускам нить
        }

        public void run() // запус нити
        {
            try
            {
                Thread.sleep(3000); // спим 3 секунды
            }
            catch (InterruptedException x)
            {
                throw new RuntimeException("My exception message");
                // или выводим ошибку
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
        // унаследованный класс от Thread.UncaughtExceptionHandler
    {
        @Override
        public void uncaughtException(Thread t, Throwable e)
                //переопределяем метод uncaughtException для вывода типа Нить 1: My exception message
        {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
