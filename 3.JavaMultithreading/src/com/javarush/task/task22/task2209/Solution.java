package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] strings = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                strings = reader.readLine().split(" ");

            }
        }
        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }
    //C:\Prog\JavaRushTasks\3.JavaMultithreading\src\com\javarush\task\task22\task2209\test
    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return new StringBuilder("");
        }
        List<String> list = new ArrayList<>(Arrays.asList(words));
        int size = list.size();
        StringBuilder builder = new StringBuilder(list.get(0));
        for (int j = 1; j < size; j++) {
            for (int i = 1; i < list.size(); i++) {
                String firstStart;
                if (builder.toString().contains(" ")) {
                    firstStart = builder.substring(builder.lastIndexOf(" ") + 1, builder.lastIndexOf(" ") + 2);
                } else {
                    firstStart = builder.substring(0, 1);
                }
                String firstEnd = builder.substring(builder.length() - 1);
                String second = list.get(i);
                String secondStart = second.substring(0, 1);
                String secondEnd = second.substring(second.length() - 1);
                if (firstStart.equalsIgnoreCase(secondEnd) && !(builder.toString().matches(second))) {
                    builder.insert(0, second + " ");
                } else if (firstEnd.equalsIgnoreCase(secondStart) && !(builder.toString().matches(second))) {
                    builder.append(" ").append(second);
                } else if (builder.toString().matches(second)) {
                    list.remove(second);
                } else {
                    list.remove(second);
                    list.add(second);
                }
            }

        }

        return builder;

    }
}

