package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reader = new FileInputStream(bufferedReader.readLine());
        FileOutputStream writer = new FileOutputStream(bufferedReader.readLine())) {
            List<Integer> list = new ArrayList<>();
            while (reader.available() > 0) {
                list.add(reader.read());
            }
            Collections.reverse(list);

            for (Integer i : list) {
                writer.write(i);
            }
        }
    }
}
