package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.Inet4Address;

import static java.lang.Integer.toBinaryString;

/* 
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        if (allModifiers == Solution.class.getModifiers() && specificModifier == Modifier.PUBLIC)
            return true;
        if (allModifiers == Solution.class.getModifiers() && specificModifier == Modifier.STATIC)
            return false;
        if (allModifiers == getMainMethod().getModifiers() && specificModifier == Modifier.STATIC)
            return true;
        return false;
    }

    /*public static final int PUBLIC           = 0x00000001;
    public static boolean isPublic(int mod) {
        return (mod & PUBLIC) != 0;
    }

    public static final int PRIVATE          = 0x00000002;
    public static boolean isPrivate(int mod) {
        return (mod & PRIVATE) != 0;
    }*/

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
