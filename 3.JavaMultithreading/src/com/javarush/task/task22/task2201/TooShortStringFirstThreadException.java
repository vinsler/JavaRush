package com.javarush.task.task22.task2201;

public class TooShortStringFirstThreadException extends RuntimeException {

    // допиливаем конструктор для эксепшена наследование через третьи руки от RuntimeException
    public TooShortStringFirstThreadException(StringIndexOutOfBoundsException cause) {
        super(cause);
    }
}
