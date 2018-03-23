package com.javarush.task.task15.task1512;

/* 
Максимально простой код-2
*/

public class Solution
{
    public static void main(String[] args)
    {
        SiamCat simka = new SiamCat("Simka");
        NakedCat nakedSimka = simka.shave();
    }

    public static class NakedCat
    {
        /*
        public NakedCat()
        {
            super();
        }*/
    }

    public static class NormalCat extends NakedCat // first
    {
        /*public NormalCat()
        {
            super();
        }*/

        public NormalCat(String name)
        {
            System.out.println("My name is " + name);
        }

        public NakedCat shave()
        {
            return this;
        }
    }

    public static class SiamCat extends NormalCat // second
    {
        public SiamCat(String name)
        {
            super(name);
        }
    }
}
