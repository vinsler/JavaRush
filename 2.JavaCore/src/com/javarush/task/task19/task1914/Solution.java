package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sout = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(sout);

        Pattern pattern = Pattern.compile("(^\\d*)\\s(\\S)\\s(\\d*)");
        Matcher matcher = pattern.matcher(result);
        matcher.find();

        int i1 = Integer.parseInt(matcher.group(1));
        int i2 = Integer.parseInt(matcher.group(3));

        switch (matcher.group(2)){
            case "+" : {
                int res = i1 + i2;
                System.out.println(i1 + " + " + i2 + " = " + res);
                break;
            }
            case "-" : {
                int res = i1 - i2;
                System.out.println(i1 + " - " + i2 + " = " + res);
                break;
            }
            case "*" : {
                int res = i1 * i2;
                System.out.println(i1 + " * " + i2 + " = " + res);
                break;
            }
        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

