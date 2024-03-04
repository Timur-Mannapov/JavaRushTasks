package com.javarush.task.task14.task1418;

import java.util.LinkedList;
import java.util.List;

/* 
Исправь четыре ошибки
*/

public class Solution {
        public static void initList (List < Number > list) {
            list.add((1000f));
            list.add((-90 / -3));
        }


        public static void printListValues (List < Number > list) {
            for (Number object : list) {

                    System.out.println(object);
                }
            }

        public static void processCastedObjects (List < Number > list) {
            for (Number number : list) {
                if (number instanceof Float) {
                    System.out.println("Is float value defined? " + !Float.isNaN((float) number));
                } else if (number instanceof Double) {
                    System.out.println("Is double value infinite? " + Double.isInfinite((double) number));
                }
            }
        }
    public static void main(String[] args) {
        List<Number> list = new LinkedList<Number>();
        initList(list);
        printListValues(list);
        processCastedObjects(list);
    }
}
