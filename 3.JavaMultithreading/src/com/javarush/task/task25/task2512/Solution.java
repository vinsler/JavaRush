package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList <String> list = new ArrayList<>(); // создаем лист для строк чб вывести в консоль
        while (e != null){ // пока есть вложенные exception
            list.add(e.getClass().getName() + ": " + e.getMessage()); // сохраняем строку в лист
            e = e.getCause(); // присваиваем вложенный exception or null
        }
        for (int i = list.size() - 1; i > -1; i--) { // выводим в обратном порядке
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        // это для теста
        new Solution().uncaughtException(Thread.currentThread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
