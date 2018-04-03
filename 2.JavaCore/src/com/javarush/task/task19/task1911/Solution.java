package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();


    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        // PrintStream - это класс, в котором есть метод println();
        // создаем переменную его типа с именем consoleStream == println;
        // и присваиваем ей то, что должно вылезти в println;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Создаем переменную класса ByteArrayOutputStream, которая наследуется от OutputStream

        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        // Создаем переменную stream == println, и создаем ей новый обьект вывода в консоль
        // передаем в него буфер outputStream

        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        // устанавливаем поток для вывода в консоль stream

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString().toUpperCase();

        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println(result);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
