package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution
{
    public static void main(String[] args)
    {

    }
    
    static
    {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        switch (reader.readLine()) {
            case "helicopter":{
                result = new Helicopter();
                break;
            }
            case "plane": {
                result = new Plane(1);
                break;
            }
        }
        reader.close();
    }
}
