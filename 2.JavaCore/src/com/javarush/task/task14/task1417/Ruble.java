package com.javarush.task.task14.task1417;

public class Ruble extends Money
{
    public Ruble(double dbl)
    {
        super(dbl);
    }

    @Override
    public String getCurrencyName()
    {
        return "RUB";
    }
}
