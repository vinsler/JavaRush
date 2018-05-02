package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/* 
Наследование от внутреннего класса
*/

public class Solution {

    public class Apt3Bedroom extends Building.Apartments { // внутренний класс лвл 1
        Apt3Bedroom(Building building) {
            building.super();
        }
    }

    public class BigHall extends Building.Hall{ // внутренний класс лвл 1 наследуем через внешний
        public BigHall(BigDecimal square, Building building) { // спец конструктор с инстансом внешнего и полем внутреннего
            building.super(square); // через инстанс внешнего отправляем поле для внутреннего
        }
    }

    public class Building { // внутренний класс лвл 1


        public class Hall { // внутренний класс лвл 2
            private BigDecimal square;
            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments { // внутренний класс лвл 2
        }
    }



    public static void main(String[] args) {

    }
}
