package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        String result = null;
        for (int i = 2; i <= 36; i++) {
            try {
                BigInteger bigInteger = new BigInteger(args[0], i);
                result = String.valueOf(i);
                break;
            } catch (Exception e) {
                result = "incorrect";
            }
        }
        System.out.println(result);
    }
}