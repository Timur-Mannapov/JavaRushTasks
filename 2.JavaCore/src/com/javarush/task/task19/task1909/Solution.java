package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(input.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(input.readLine()))) {
            while (reader.ready()) {
                writer.write(reader.readLine().replaceAll("\\.","\\!"));
            }
        }
    }
}
