package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._2, "120");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._10);
        System.out.println(result);
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        int numberSystemIntValue = number.getNumberSystem().getNumberSystemIntValue();

        String numb = number.getDigit();
        BigInteger bigInteger = new BigInteger(numb, numberSystemIntValue);
        String expectedSystem = bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue());
        Number result = new Number(expectedNumberSystem, expectedSystem);


        return result;
    }
}
