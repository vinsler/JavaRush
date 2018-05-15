package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                this.wait(); // ждем value пока его нет
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value); // получен
        isValuePresent = false; // меняем
        this.notify(); // пробуждаем нить
        return value; // возвращаем
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                this.wait(); // ждем пока value есть
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value; // кладем
        System.out.println("Put: " + value); // кладем
        isValuePresent = true; // меняем
        this.notify(); // пробуждаем нить
    }
}