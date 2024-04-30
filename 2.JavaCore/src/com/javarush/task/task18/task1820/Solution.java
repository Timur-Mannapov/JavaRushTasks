package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            FileReader fileOne = new FileReader(input.readLine());
            BufferedReader readerOne = new BufferedReader(fileOne);
            FileWriter fileTwo = new FileWriter(input.readLine());

            while (readerOne.ready()) {
                String[] array = readerOne.readLine().split(" ");
                for (int i = 0; i < array.length; i++) {
                    fileTwo.write(Math.round(Float.parseFloat(array[i])) + " ");
                }
            }
            fileOne.close();
            fileTwo.close();
            readerOne.close();
        }
    }
}
