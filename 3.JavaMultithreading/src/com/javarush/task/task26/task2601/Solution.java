package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Integer[] array = new Integer[]{10, 20, 40, 50, 30, 60};
//        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int median = 0;
        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        } else {
            median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        }

        int finalMedian = median;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int result = Math.abs(finalMedian - a) - Math.abs(finalMedian - b);
                if (result == 0) {
                    return Integer.compare(a, b);
                }
                return result;
            }
        };
        Arrays.sort(array, comparator);

        return array;
    }
}
