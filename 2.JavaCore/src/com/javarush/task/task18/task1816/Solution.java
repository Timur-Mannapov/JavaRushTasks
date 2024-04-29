package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader(args[0])) {
            int count = 0;
            while (reader.ready()) {
                char ch = (char) reader.read();
                String str = String.valueOf(ch);
                if (str.matches("[a-zA-Z]")) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
