package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 50;
    }

    String getDescription()
    {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");

        // return super.getDescription() +
        // " Моя страна - " + Country.BELARUS +
        // ". Я несу " + getCountOfEggsPerMonth() +
        // " яиц в месяц.";
    }
}
