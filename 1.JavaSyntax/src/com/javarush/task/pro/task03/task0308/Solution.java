package com.javarush.task.pro.task03.task0308;

import java.util.Scanner;

/* 
Координатные четверти
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int x = console.nextInt();
        int y = console.nextInt();
        boolean part1 = ((x>0) && (y>0));
        boolean part2 = ((x<0) && (y>0));
        boolean part3 = ((x<0) && (y<0));
        boolean part4 = ((x>0) && (y<0));
        if (part1) {
            System.out.println(1);
        } else if (part2) {
            System.out.println(2);
        } else if (part3) {
            System.out.println(3);
        } else if (part4) {
                System.out.println(4);
            }
        }
    }

