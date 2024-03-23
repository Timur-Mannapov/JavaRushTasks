package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String[] split = string.split(" ");
                String name = split[0];
                double value = Double.parseDouble(split[1]);
                if (!map.containsKey(name)) {
                    map.put(name,value);
                } else {
                    map.put(name, map.get(name) + value);
                }
            }
        }
        Double max = Double.MIN_VALUE;
        for (Double value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        Set<String> set = new TreeSet<>();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), max)) {
                set.add(entry.getKey());
            }
        }
        set.forEach(System.out::println);
    }
}
