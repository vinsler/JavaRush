package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 30;
    }

    String getDescription()
    {
        return super.getDescription() +
                " Моя страна - " + Country.UKRAINE +
                ". Я несу " + getCountOfEggsPerMonth() +
                " яиц в месяц.";

        // return super.getDescription() +
        // " Моя страна - " + Country.BELARUS +
        // ". Я несу " + getCountOfEggsPerMonth() +
        // " яиц в месяц.";
    }
}
