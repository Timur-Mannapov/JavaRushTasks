package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(bufferedReader.readLine())) {
            int max = 0;
            while (input.available() > 0) {
                int console = input.read();
                if (console > max) {
                    max = console;
                }
            }
            System.out.println(max);
        }
    }
}
