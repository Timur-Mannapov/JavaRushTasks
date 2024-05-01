package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            FileReader reader = new FileReader(input.readLine());
            BufferedReader bufferedReader = new BufferedReader(reader);
            boolean flag = true;
            while (flag) {
                String[] str = bufferedReader.readLine().split(" ");
                if (Integer.parseInt(str[0]) == Integer.parseInt(args[0])) {
                    System.out.println(str[0] + " " + str[1] + " " +str[2] + " " +str[3]);
                    flag = false;
                }
            }
            reader.close();
            bufferedReader.close();
        }
    }
}
