package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            new Cat();
        }
        
        //создай 10 котов

        //выведи значение переменной catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        public static int catCount;
        
        public Cat()
        {
            Cat.catCount++;
        }
        //создай статическую переменную catCount

        //создай конструктор
    }
}
