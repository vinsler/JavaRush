package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>...  comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) { // переписываем с двумя дженериками <T>
            int res = 0;
            for (Comparator comporator: comparators) { // проходим по всем компораторам
                res = comporator.compare(o1, o2); // смотрим чего там 0 1 -1
                if (res != 0) { // если компораторы разные выводим результат
                    break;
                }
            }
            return res;
        }



        //4. Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке,
        //соответствующем последовательности компараторов comparators.
    }


    public static void main(String[] args) {

    }
}
