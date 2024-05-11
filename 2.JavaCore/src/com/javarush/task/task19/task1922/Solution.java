package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(input.readLine()))) {
            ArrayList<String> list = new ArrayList<>();
            while (reader.ready()) {
                String str = reader.readLine();
                int count = 0;
                String[] strings = str.split(" ");
                for (int i = 0; i < strings.length; i++) {
                    for (int j = 0; j < words.size(); j++) {
                        if (strings[i].equals(words.get(j))) {
                            count++;
                        }
                        if (i == strings.length-1 && j == words.size()-1 && count == 2) {
                            list.add(str);
                        }
                    }
                }
                }
            for (String string : list) {
                System.out.println(string);
            }
        }
    }
}
