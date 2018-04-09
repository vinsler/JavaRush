package com.javarush.task.task20.task2015;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable{
    transient private Thread runner; // поле типа поток транзитное
    private int speed; // поле инт

    public Solution(int speed) { // конструктор с параметром инт
        this.speed = speed;
        runner = new Thread(this); // новый поток Solution
        runner.start(); // и запускаем тут же
    }

    public void run() { // а в ране что нужно ?
        // do something here, does not matter
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */

    private void writeObject(ObjectOutputStream out) throws IOException {
        // пишем обьект для сериализации
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // читаем обьект для сериализации
        in.defaultReadObject();

        //runner = (Thread) in.readObject();
        Thread thread = new Thread(this);
        thread.start();

    }

    public static void main(String[] args) {

    }
}
