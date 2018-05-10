package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    public static void main(String[] args) {
        Integer [] intarr = {5, 1, 3, 5, 8};
        sort(intarr);

        for (Integer tge: intarr) {
            //System.out.println(tge);
        }
    }

    public static Integer[] sort(Integer[] array) {
        int MEDIANA; // это медиана
        Arrays.sort(array);
        if (array.length % 2 == 0) { // находим медиану если длинна четная
            MEDIANA = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
        else { // или не четная
            MEDIANA = array[array.length / 2];
        }

        /*Comparator<Integer> comp = // сначала пишем нечто класс и выделяем память, потом инициализируем
                new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) { // потом определяем метод, возврат и переменные для работы
                return Math.abs(o1 - MEDIANA) - Math.abs(o2 - MEDIANA); //  и возврат чего-то
            }
        };*/

        Comparator<Integer> comp = // сначала пишем нечто класс и выделяем память, потом инициализируем
                (o1, o2) -> // потом определяем метод, возврат и переменные для работы
                        Math.abs(o1 - MEDIANA) - Math.abs(o2 - MEDIANA); //  и возврат чего-то

        /*Arrays.sort(array, // это все в одном методе с оболочными интовым компаром
                (x,y) -> Integer.compare(Math.abs(MEDIANA - x),
                        Math.abs(MEDIANA - y)));*/

        Arrays.sort(array, comp);
        return array;
    }


}
