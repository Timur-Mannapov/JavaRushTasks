package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] words = url.substring(url.lastIndexOf("?") + 1).split("&");
        for (String word : words) {
            System.out.print(word.contains("=") ? word.substring(0, word.indexOf("=")) + " " : word + " ");
        }
        System.out.println();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains("obj")) {
                String string = words[i].substring(words[i].indexOf("=")+1);
                try {
                    double doub = Double.parseDouble(string);
                    alert(doub);
                } catch (NumberFormatException e) {
                    alert(string);
                }
            }
        }
    }


            public static void alert ( double value){
                System.out.println("double: " + value);
            }

            public static void alert (String value){
                System.out.println("String: " + value);
            }
        }




