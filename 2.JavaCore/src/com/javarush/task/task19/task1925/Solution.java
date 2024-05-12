package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                String[] strings = reader.readLine().split(" ");
                for (String string : strings) {
                    if (string.length() > 6) {
                        builder.append(string + ",");
                    }
                }
            }
            writer.write(builder.toString().replaceAll(",$",""));
        }

    }
}
