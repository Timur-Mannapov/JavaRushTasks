package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream file = new FileInputStream(console.readLine());
             BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            while (reader.ready()) {
                String string = reader.readLine();
                System.out.println(string);

            }
        }
    }
}