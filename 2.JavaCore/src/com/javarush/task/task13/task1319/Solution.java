package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileWriter read = new FileWriter(console.readLine());
             BufferedWriter writer = new BufferedWriter(read)) {
            while (true) {
                String string = console.readLine();
                writer.newLine();
                writer.write(string);
                if (string.equalsIgnoreCase("exit")) {
                    break;
                }

            }


        }
    }


}

