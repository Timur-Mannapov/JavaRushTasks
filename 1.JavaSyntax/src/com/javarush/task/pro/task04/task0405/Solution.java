package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int q = 0;
        while (q < 10) {
            int n = 0;
            while (n < 20) {
                if (n > 0 && q > 0 && n <19 && q <9) {
                    System.out.print(" ");
                } else {
                    System.out.print("Б");
                }
                n++;
            }

            System.out.println();


            q++;
        }
    }
}