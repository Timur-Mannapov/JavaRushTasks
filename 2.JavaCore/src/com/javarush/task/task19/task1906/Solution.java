package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            FileReader reader = new FileReader(input.readLine());
            ArrayList<Character> list = new ArrayList<>();
            while (reader.ready()) {
                list.add((char) reader.read());
            }
            FileWriter writer = new FileWriter(input.readLine());
            for (int i = 1; i < list.size(); i++) {
                if (!(i % 2 == 0)) {
                    writer.write(list.get(i));
                }
            }
            reader.close();
            writer.close();

        }
    }
}
