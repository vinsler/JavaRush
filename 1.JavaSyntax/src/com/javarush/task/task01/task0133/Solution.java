package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getCountSecondsPassedInCurrentHour(12345));
    }

    public static int getCountSecondsPassedInCurrentHour(int seconds) {
        int i = (seconds / 3600);
        int j = seconds - (3600 * i);
        return j; 
        
        //напишите тут ваш код
    }
}