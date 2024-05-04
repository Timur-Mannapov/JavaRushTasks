package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            FileReader reader = new FileReader(input.readLine());
            BufferedReader readerFile = new BufferedReader(reader);
            int count = 0;
            while (readerFile.ready()) {
                String[] strings = readerFile.readLine().split("(\\W)");
                for (String string : strings) {
                    if (string.equals("world")) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            reader.close();
            readerFile.close();
        }
    }
}
