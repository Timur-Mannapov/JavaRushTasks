package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int endNumber = number;
        List<Integer> list = new LinkedList<>();
        List<Integer> enumList = new LinkedList<>();
        enumList.add(1);
        enumList.add(3);
        enumList.add(9);
        enumList.add(27);
        enumList.add(81);
        enumList.add(243);
        enumList.add(729);
        enumList.add(2187);


        for (int i = 0; i < enumList.size(); i++) {
            int value = enumList.get(i);
            if (number == 0) {
                break;
            }
            int three = number % 3;
            number = number / 3;

            if (three == 1) {
                list.add(value);
            } else if (three == 2) {
                list.add(-value);
                number++;
            }
        }

        System.out.print(endNumber + " =");
        for (int i = 0; i < list.size(); i++) {
            int result = list.get(i);
            if (result > 0) {
                System.out.print(" + " + result);
            } else if (result < 0) {
                System.out.print(" - " + result * (-1));
            }
        }
    }
}