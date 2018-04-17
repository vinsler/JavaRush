package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        if (string == null) throw new RuntimeException(); // если строка нулевая, то исключение
        String str; // создаем новую строку
        try {
            str = string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t"));
            // присваиваем ей значение между табуляциями
        } catch (StringIndexOutOfBoundsException  e) { // обрабатываем исключение
            if (threadName.equals(Solution.FIRST_THREAD_NAME)) throw new TooShortStringFirstThreadException(e);
            // если имя нити первое то кидаем первое исключение
            if (threadName.equals(Solution.SECOND_THREAD_NAME)) throw new TooShortStringSecondThreadException(e);
            // если второе, то второе
            throw new RuntimeException(e); // если не то и не то, то рантайм эксепшн
        }
        return str; // а если все норм, то возвращаем строку между табами.
    }
}
