package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = null;
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                if (reader.readLine() == null) {
                    str = reader.readLine();
                }
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(str);

        }
    }
}