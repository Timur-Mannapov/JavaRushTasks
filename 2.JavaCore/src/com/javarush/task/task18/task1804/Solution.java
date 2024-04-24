package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream reader = new FileInputStream(bufferedReader.readLine())) {
            ArrayList<Integer> list = new ArrayList<>();
            while (reader.available() > 0) {
                list.add(reader.read());
            }
            Map<Integer, Integer> map = new TreeMap<>();
            int count = 0;
            for (Integer i : list) {
                map.put(i, count++);
            }
            System.out.println(map.get(map.size()));
        }
    }
}

