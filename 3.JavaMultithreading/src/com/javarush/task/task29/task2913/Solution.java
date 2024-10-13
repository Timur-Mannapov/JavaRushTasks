package com.javarush.task.task29.task2913;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
//        if (a > b) {
//            return a + " " + recursion(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + recursion(a + 1, b);
//        }

//        List<String> list = new LinkedList<>();
//        boolean flag = true;
//        while (flag) {
//            if (a > b) {
//                list.add(a + "");
//                a--;
//                if (a == b) {
//                    list.add(a +"");
//                    flag = false;
//                }
//            } else if (a < b) {
//                list.add(a + "");
//                a++;
//                if (a == b) {
//                    list.add(a +"");
//                    flag = false;
//                }
//            } else {
//                return a + "";
//            }
//        }
//        StringBuilder builder = new StringBuilder();
//        for (String string : list) {
//            builder.append(string).append(" ");
//        }
//        return builder.deleteCharAt(builder.length()).toString();

        return a > b ?
                IntStream.iterate(a, i -> i >= b, i -> i - 1).mapToObj(String::valueOf).collect(Collectors.joining(" "))
                : IntStream.rangeClosed(a, b).mapToObj(String::valueOf).collect(Collectors.joining(" "));


//        StringBuilder builder = new StringBuilder();
//        if (a > b) {
//            for (int i = a; i >= b; i--) {
//                builder.append(i).append(" ");
//            }
//        } else {
//            for (int i = a; i <= b; i++) {
//                builder.append(i).append(" ");
//            }
//        }
//        return builder.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}