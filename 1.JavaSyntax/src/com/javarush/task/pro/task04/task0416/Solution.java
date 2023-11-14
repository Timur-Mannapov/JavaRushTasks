package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int cola = console.nextInt();
        int cabinet = console.nextInt();
        double result = (cola+0.0) / cabinet;
        System.out.println(result);

    }
}