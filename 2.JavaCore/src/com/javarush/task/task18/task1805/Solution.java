package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream reader = new FileInputStream(bufferedReader.readLine())) {
            Set<Integer> set = new TreeSet<>();
            while (reader.available() > 0) {
            set.add(reader.read());
            }
            for (Integer i : set) {
                System.out.print(i + " ");
            }
        }
    }
}
