package com.javarush.task.pro.task02.task0215;

import java.util.Scanner;

/* 
Чтение чисел
*/

public class Solution {

    public static void main(String[] args) {
        Scanner n1 = new Scanner(System.in);
        int nn1 = n1.nextInt();
        Scanner n2 = new Scanner(System.in);
        int nn2 = n2.nextInt();
        Scanner n3 = new Scanner(System.in);
        int nn3 = n3.nextInt();
        System.out.println((nn3+nn1+nn2)/3);

    }
}
