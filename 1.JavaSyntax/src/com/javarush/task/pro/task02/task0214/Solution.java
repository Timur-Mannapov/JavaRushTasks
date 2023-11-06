package com.javarush.task.pro.task02.task0214;

import java.util.Scanner;

/* 
Чтение и преобразование строк
*/

public class Solution {

    public static void main(String[] args) {
        Scanner  s1 = new Scanner(System.in);
        String ss1 = s1.nextLine();
        Scanner  s2 = new Scanner(System.in);
        String ss2 = s2.nextLine();
        Scanner  s3 = new Scanner(System.in);
        String ss3 = s3.nextLine();

        System.out.println(ss3);
        System.out.println(ss2.toUpperCase());
        System.out.println(ss1.toLowerCase());

    }
}
