package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int firstArray = console.nextInt();
        multiArray = new int[firstArray][];
        for (int i = 0; i < multiArray.length; i++) {
            int secondArray = console.nextInt();
            multiArray[i] = new int[secondArray];
            for (int j = 0; j < secondArray; j++) {
            }
        }
    }
}

