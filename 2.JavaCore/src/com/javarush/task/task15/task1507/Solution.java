package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, Object value) {
        int sum = m + 5;
    }

    public static void printMatrix(String value) {
        System.out.println(value);
    }

    public static void printMatrix(int m, int n) {
        int sum = m + n;
        System.out.println(sum);
    }

    public static void printMatrix(int m, String value) {
        System.out.println(m);
    }

    public static void printMatrix(int n, Object value, int m) {
        System.out.println(n);
    }

    public static void printMatrix(String value, int a) {
        System.out.println(value);
    }

    public static void printMatrix(int m, int n, int d) {
        System.out.println(m);
    }

    public static void printMatrix(int n) {
        System.out.println(n);
    }

}
