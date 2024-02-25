package com.javarush.task.task13.task1326;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream reader = new FileInputStream(console.readLine());
             BufferedReader read  = new BufferedReader(new InputStreamReader(reader))) {
            ArrayList<Integer> list = new ArrayList<>();
            while (read.ready()) {
                String string = read.readLine();
                int allNum = Integer.parseInt(string);
                if (allNum % 2 == 0) {
                    list.add(allNum);
                }
            }
            Collections.sort(list);
            for (Integer num : list) {
                System.out.println(num);

            }
        }
    }
}
