package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            while (reader.ready()) {
                String[] strings = reader.readLine().split(" ");
                for (String string : strings) {
                    Pattern pattern = Pattern.compile("\\d");
                    Matcher matcher = pattern.matcher(string);
                    if (matcher.find()) {
                        writer.write(string + " ");
                    }
                }
            }
        }
    }
}
