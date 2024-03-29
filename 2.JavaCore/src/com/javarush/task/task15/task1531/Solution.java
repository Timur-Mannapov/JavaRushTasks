package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }


    public static BigInteger factorial(int n) {

        if (n < 2) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(factorial(n - 1));

    }


    public static String factorial1(int n) {
        BigInteger fact = BigInteger.ONE;
        if (n < 0) {
            return "0";
        }
        if (n == 0) {
            return "1";
        }
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));

        }
        return fact.toString();
    }
}
