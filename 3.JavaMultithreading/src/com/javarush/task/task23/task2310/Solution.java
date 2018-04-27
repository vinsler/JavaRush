package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
*/
public class Solution {
    private String name;

    Solution(String name) { // конструктор с полем private String name;
        this.name = name;
    }

    public String getName() { // метод public или private вернет имя
        return name;
    }

    private void sout() {
        new Solution("sout") { // создаем внутренний класс
            void printName() { // пишем метод печатьИмени
                System.out.println(getName()); // печатаем Имя
            }
        }.printName(); // и выводим только что написанный метод
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
