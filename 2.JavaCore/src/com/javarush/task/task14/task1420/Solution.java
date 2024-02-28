package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String stringOne = reader.readLine();
        String stringTwo = reader.readLine();
        BigInteger one = new BigInteger(stringOne);
        BigInteger two = new BigInteger(stringTwo);
        System.out.println(one.gcd(two));
        System.out.println(new BigInteger(reader.readLine()).gcd(new BigInteger(reader.readLine())));
    }












    public static void main1(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOne = Integer.parseInt(reader.readLine());
            int numberTwo = Integer.parseInt(reader.readLine());
            int number = Math.min(numberOne,numberTwo);
            for (int i = number; i > 0 ; i--) {
                if ((numberOne % i == 0) && (numberTwo % i == 0)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
