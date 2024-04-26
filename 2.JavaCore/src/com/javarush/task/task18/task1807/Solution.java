package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reader = new FileInputStream(bufferedReader.readLine())) {
            int count = 0;
            char zap = ',';
            while (reader.available() > 0) {
                char value = (char) reader.read();
                if (zap == value) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}