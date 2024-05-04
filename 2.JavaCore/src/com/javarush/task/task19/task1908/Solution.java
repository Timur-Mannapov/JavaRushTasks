package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String inputFile = input.readLine();
            String outputFile = input.readLine();

            try (BufferedReader readerFile = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writerFile = new BufferedWriter(new FileWriter(outputFile))) {
                Pattern pattern = Pattern.compile("\\b\\d+\\b");
                String line;
                while ((line = readerFile.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        writerFile.write(matcher.group() + " ");
                    }
                }
            }
        }
    }
}
