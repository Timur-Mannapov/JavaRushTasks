package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream reader = new FileInputStream(bufferedReader.readLine())) {
            ArrayList<Integer> list = new ArrayList<>();
            while (reader.available() > 0) {
                list.add(reader.read());
            }
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer i : list) {
                map.put(i, count++);
            }
            int maxValue = Collections.max(map.values());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }
}
