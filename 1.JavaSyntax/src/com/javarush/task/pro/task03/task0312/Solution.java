package com.javarush.task.pro.task03.task0312;

import java.util.Scanner;

/* 
Сравним строки
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String x = console.nextLine();
        String y = console.nextLine();
        if (x.equals(y)) {
            System.out.println("строки одинаковые");
        } else {
            //напишите тут ваш код
            System.out.println("строки разные");
        }
    }
}
