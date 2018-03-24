package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)    {
            String str = reader.readLine();

            if (str.equals("exit"))     {
                break;
            }

            try     {
                Double.parseDouble(str);
            }
            catch (Exception e)     {
                print(str);
                continue;
            }

            if (str.contains(".")) {
                print(Double.parseDouble(str));
            }

            if (Short.parseShort(str) > 0 && Short.parseShort(str) < 128)   {
                print((Short)Short.parseShort(str));
            }
            else if (Integer.parseInt(str) <= 0 && Integer.parseInt(str) >= 128)    {
                print((Integer)Integer.parseInt(str));
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
