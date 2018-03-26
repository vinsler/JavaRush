package com.javarush.task.task17.task1707;


public class IMF
{

    private static IMF imf;
    // 1. Класс IMF должен содержать приватное статическое поле IMF imf.

    public static IMF getFund()
    // 3. Класс IMF должен содержать публичный статический метод IMF getFund().
    {
        synchronized (IMF.class) // 4. Метод getFund() должен содержать синхронизированный блок.
        {// 5. Внутри синхронизированного блока должно быть проинициализировано поле imf.

            if (imf == null)
            {
                imf = new IMF();
            }

            return imf;
        }


    }

    private IMF()
    // 2. Класс IMF должен содержать приватный конструктор.
    {
    }
}
