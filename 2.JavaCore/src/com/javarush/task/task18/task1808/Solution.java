package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream reader = new FileInputStream(bufferedReader.readLine());
             FileOutputStream writer = new FileOutputStream(bufferedReader.readLine());
             FileOutputStream writerTwo = new FileOutputStream(bufferedReader.readLine())) {
            List<Integer> list = new ArrayList<>();
            while (reader.available() > 0) {
                list.add(reader.read());
            }

            int half = list.size() / 2;
            if (list.size() % 2 == 0) {
                for (int i = 0; i < half; i++) {
                    writer.write(list.get(i));
                }
                for (int i = half; i < list.size(); i++) {
                    writerTwo.write(list.get(i));
                }
            } else {
                for (int i = 0; i < half + 1; i++) {
                    writer.write(list.get(i));
                }
                for (int i = half + 1; i < list.size(); i++) {
                    writerTwo.write(list.get(i));
                }
            }
        }
    }
}
