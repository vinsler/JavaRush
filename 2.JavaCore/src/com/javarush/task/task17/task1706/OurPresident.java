package com.javarush.task.task17.task1706;

public class OurPresident
{

    static // 4+
    {
        synchronized (OurPresident.class)  // 5+
        {
            president =  new OurPresident();
        }

    }

    private static OurPresident president; // 1 +

    private OurPresident() // 3+
    {
    }

    public static OurPresident getOurPresident() // 2+
    {
        return president;
    }
}
