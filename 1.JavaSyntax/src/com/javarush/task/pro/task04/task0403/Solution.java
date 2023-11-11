package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int sum = 0;
        while (true) {
            if (console.hasNextInt()) {
                int num = console.nextInt();
                sum = num + sum;
               } else if (console.hasNextLine()) {
                String string = console.nextLine();
                if ("ENTER".equals(string)) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
