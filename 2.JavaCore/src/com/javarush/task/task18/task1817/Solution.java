package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (FileReader readerFile = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(readerFile)) {
            double countAll = 0;
            double count = 0;
            while (reader.ready()) {
                char ch = (char) reader.read();
                if (ch == ' ') {
                    count++;
                }
                    countAll++;
            }
            double result = count/countAll*100;

            System.out.printf("%.2f",result);
        }
    }
}
