package com.javarush.task.task14.task1417;

public class Hrivna extends Money
{
    public Hrivna(double dbl)
    {
        super(dbl);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
