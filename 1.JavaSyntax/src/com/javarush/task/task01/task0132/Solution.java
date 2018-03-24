package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        if (number < 10) return number;
        int i = 0;
        while (number > 10)
        {
            i += (number % 10);
            number /= 10;
        }
        i += number;
        return i;
        //напишите тут ваш код
    }
}