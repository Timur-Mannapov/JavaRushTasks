package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws  IOException{
       try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String fileOne = input.readLine();
            String fileTwo = input.readLine();
            BufferedReader bufferedReaderOne = new BufferedReader(new FileReader(fileOne));
            BufferedReader bufferedReaderTwo = new BufferedReader(new FileReader(fileTwo));
            FileWriter writerOne = new FileWriter(fileOne);

            List<String> list = new ArrayList<>();
            while (bufferedReaderTwo.ready()) {
                list.add(bufferedReaderTwo.readLine());
            }
            while (bufferedReaderOne.ready()) {
                list.add(bufferedReaderOne.readLine());
            }
           for (String string : list) {
               writerOne.write(string);
           }
           bufferedReaderOne.close();
           bufferedReaderTwo.close();
           writerOne.close();
        }
    }
}
