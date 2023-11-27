package com.javarush.task.pro.task08.task0809;

/* 
Counter

*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        printNumbers();
    }

    public static void printNumbers() throws InterruptedException {
       int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
            System.out.println(array[i]);
            if (i<9) {
                Thread.sleep(1, 300_000);
            }
        }
    }
}
