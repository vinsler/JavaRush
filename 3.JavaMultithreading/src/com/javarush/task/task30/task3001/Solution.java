package com.javarush.task.task30.task3001;

/* 
Конвертер систем счислений
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumerationSystemType._16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        //int i = Integer.parseInt(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue() );
        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        return new Number(expectedNumerationSystem, bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue()));
        //return new Number(expectedNumerationSystem, Integer.toString(i, expectedNumerationSystem.getNumerationSystemIntValue()));
    }
}
