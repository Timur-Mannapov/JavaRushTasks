package com.javarush.task.task18.task1826;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile = args[1];
        String outputFile = args[2];
        try (FileInputStream input = new FileInputStream(inputFile);
             FileOutputStream output = new FileOutputStream(outputFile)) {
            if (args[0].equals("-e")) {
                while (input.available() > 0) {
                    output.write(input.read() * 2);
                }
            } else {
                while (input.available() > 0) {
                    output.write(input.read() / 2);
                }

            }
        }
    }
}
