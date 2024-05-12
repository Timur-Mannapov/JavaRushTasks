package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(input.readLine()))) {
            while (reader.ready()) {
                StringBuilder builder = new StringBuilder(reader.readLine());
                builder.reverse();
                System.out.println(builder);
            }
        }
    }
}
