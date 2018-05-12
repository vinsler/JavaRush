package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock(); // private

    public void someMethod() {
        if (lock.tryLock()) {
            try {
                ifLockIsFree();
            } finally {
                lock.unlock();
            }
        } else {
            try {
                ifLockIsBusy();
            } catch (Exception e) {}
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
