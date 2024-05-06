package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> map = new TreeMap<>();
            while (reader.ready()) {
                String[] split = reader.readLine().split(" ");
                map.merge(split[0], Double.parseDouble(split[1]),Double::sum);
            }

            for (Map.Entry<String, Double> stringDoubleEntry : map.entrySet()) {
                System.out.println(stringDoubleEntry.getKey() + " " + stringDoubleEntry.getValue());
            }
        }
    }
}
