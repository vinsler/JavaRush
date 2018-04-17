package com.javarush.task.task22.task2201;

public class TooShortStringSecondThreadException extends RuntimeException {
    // допиливаем конструктор для эксепшена наследование через третьи руки от RuntimeException
    public TooShortStringSecondThreadException(StringIndexOutOfBoundsException cause) {
        super(cause);
    }
}
