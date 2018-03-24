package com.javarush.task.task15.task1530;

public abstract class DrinkMaker
{
    abstract void getRightCup();      // выбрать подходящую чашку
    abstract void putIngredient();    // положить ингредиенты
    abstract void pour();             // залить жидкостью

    void makeDrink()        // выбирает чашку, кладет ингредиенты, заливает жидкостью.
    {
        getRightCup();
        putIngredient();
        pour();
    }

}
