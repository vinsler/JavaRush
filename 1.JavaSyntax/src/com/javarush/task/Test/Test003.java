package com.javarush.task.Test;

import java.util.ArrayList;
import static java.lang.System.*;

public class Test003 {

    class Car {

        public ArrayList createPoliceCars(int count) {
            ArrayList result = new ArrayList();

            class PoliceCar extends Car {
                // внутренний локальный класс (влк) метода createPoliceCars(int count)
                // вопрос только зачем extends ? аля рекурсия?
                // рамки видимости внутри метода позволяют видеть поля внешнего класса, но не наоборот
                int policeNumber; // поле влк
                PoliceCar(int policeNumber) { // конструктор влк
                    this.policeNumber = policeNumber;
                }
            }//class PoliceCar extends Car {

            for (int i = 0; i < count; i++)
                result.add(new PoliceCar(i)); // добавляем объект влк с параметром == счетчику i

            return result; // возвращаем список

        }//public ArrayList createPoliceCars(int count) {

    }//Car

    class Car1
    {
        public ArrayList createPoliceCars(int count)
        {
            ArrayList result = new ArrayList();

            for(int i = 0; i < count; i++)
            {
                final int number = i;
                result.add(new Car1()
                {
                    int policeNumber = number;
                });
            }
            return result;
        }
    }

    public static void main(String[] args) {
        out.println("asdfsadf");

    }
}
