package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
      /*  byte[][] a1 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };*/


        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };

        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        byte recCx = 0;

        for (int i = 1; i < a.length; i++) { // проход по строкам со 2 строки
            for (int j = 0; j < a.length; j++) { // проход по столбцам

                if (a[i][j] == 0) { // если найден 0, смотрим в пред строке была 1 ?
                    if (a[i - 1][j] == 1) { // да была 1, тогда проверяем до какой позиции идет прямоугольник
                        for (int jj = 1; jj <= a.length - j; jj++) { // тестим от позиции 1 до конца строки, ищем 0 или конец массива
                            if (j == a.length - 1) {
                                if (a[i - 1][j] == 1) {
                                    recCx++;
                                }
                                System.out.println(recCx + " find zero " + i + ":" + j);
                                break;
                            }
                            if (a[i - 1][j + jj] == 0 || a[i - 1][j + jj] == a.length - 1) {
                                j = j + (jj - 1); // цикл добавит +1
                                recCx++;
                                System.out.println(recCx + " find zero " + i + ":" + j);
                                break;
                            }
                        }
                    }
                    /*else { // a[i-1][j] == 0 нет был ноль и сейчас ноль, пох на это, смотрим дальше.
                        continue; // продолжаем новый цикл
                    }*/
                }

                else { // a[i][j] == 1;
                    if (i == a.length - 1) { // Если последняя строка смотрим 1
                        for (int jj = 1; jj <= a.length - j; jj++) {
                            if (j == a.length - 1) {
                                if (a[i - 1][j] == 0) {
                                    recCx++;
                                }
                                System.out.println(recCx + " Last str 1 " + i + ":" + j);
                                break;
                            }
                            if (a[i][j + jj] == 0 || a[i][j + jj] == a.length - 1){
                                j = j + (jj - 1); // цикл добавит +1
                                recCx++;
                                System.out.println(recCx + " Last str 1 " + i + ":" + j);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return recCx;
    }
}
