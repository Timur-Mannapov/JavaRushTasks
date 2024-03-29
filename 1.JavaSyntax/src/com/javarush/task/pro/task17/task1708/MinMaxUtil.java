package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c) {
        return Math.min((min(a, b)), c);
    }

    public static int min(int a, int b, int c, int d) {
       // return Math.min(Math.min(a, b), Math.min(c, d));
        return Math.min(min(a,b,c), d);
    }

    public static int min(int a, int b, int c, int d, int f) {
        return Math.min(min(a, b, c, d), f);
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        return Math.max((Math.max(a, b)), c);
    }

    public static int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    public static int max(int a, int b, int c, int d, int f) {
        return Math.max(Math.max(Math.max(a, b), Math.max(c, d)), f);
    }

}
