package com.javarush.task.task14.task1408;

public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 20;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

        // "getDescription() родительского класса + Моя страна - Ukraine. Я несу N яиц в месяц."
    }
}
