package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/
import static java.lang.Math.*;

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        return Math.sqrt( (abs(x1-x2))*(abs(x1-x2)) + (abs(y1-y2))*(abs(y1-y2)) );
    }

    public static void main(String[] args) {

    }
}
