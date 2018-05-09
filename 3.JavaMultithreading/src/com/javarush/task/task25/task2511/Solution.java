package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;
    public Solution(TimerTask original) {
        /*class CaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
            @Override
            public void uncaughtException(Thread t, Throwable e) { // три строки == (t, e) ->
                System.out.println(e.getMessage().replaceAll(t.getName(), t.getName().replaceAll(".", "*")));
            }
        }*/
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;

        this.handler = // new CaughtExceptionHandler();
                (t,e)-> System.out.println(e.getMessage().replace(t.getName(), t.getName().replaceAll(".","*")));
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}