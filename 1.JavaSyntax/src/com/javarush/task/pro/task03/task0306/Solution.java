package com.javarush.task.pro.task03.task0306;

import java.util.Scanner;

/* 
Треугольник
*/

public class Solution {
    private static final String TRIANGLE_EXISTS = "треугольник существует";
    private static final String TRIANGLE_NOT_EXISTS = "треугольник не существует";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int c = console.nextInt();



        boolean tru = ((a+b)>c) && ((a+c) > b) && ((b+c) > a);


        if (tru) {
            System.out.println(TRIANGLE_EXISTS);
        }  else {
                System.out.println(TRIANGLE_NOT_EXISTS);
            }


    }
}
