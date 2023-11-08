package com.javarush.task.pro.task03.task0307;

import java.util.Scanner;

/* 
Работать или не работать - вот в чем вопрос
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int age = console.nextInt();
        boolean relax = ((age < 20) || (age > 60));
        if (relax)
        System.out.println("можно не работать");
    }
}
