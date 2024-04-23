package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reader = new FileInputStream(bufferedReader.readLine())) {
            int min = Integer.MAX_VALUE;
            while (reader.available() > 0) {
                int console = reader.read();
                if (console < min) {
                    min = console;
                }
            }
            System.out.println(min);
        }
    }
}
