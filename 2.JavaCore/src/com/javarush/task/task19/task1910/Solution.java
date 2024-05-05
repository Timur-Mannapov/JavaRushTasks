package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(input.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(input.readLine()))) {
            while (reader.ready()) {
                writer.write(reader.readLine().replaceAll("\\p{P}",""));
            }
        }
    }
}
