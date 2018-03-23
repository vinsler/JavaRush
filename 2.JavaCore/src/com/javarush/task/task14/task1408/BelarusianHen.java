package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 40;
    }

    String getDescription()
    {
        return (super.getDescription()+ " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");

        // "getDescription() родительского класса + Моя страна - Ukraine. Я несу N яиц в месяц."
    }
}
