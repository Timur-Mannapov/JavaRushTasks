package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

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
            return new StringBuilder();
        }
        List<StringBuilder> builderList = new ArrayList<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            builder.append(word);
            List<String> list = new ArrayList<>(Arrays.asList(words));
            list.remove(word);
            int count = 0;
            while (!list.isEmpty()) {
                String firstStart = builder.substring(0, 1);
                String firstEnd = builder.substring(builder.length() - 1);
                String second = list.get(0);
                String secondStart = second.substring(0, 1);
                String secondEnd = second.substring(second.length() - 1);

                if (firstStart.equalsIgnoreCase(secondEnd)) {
                    builder.insert(0, second + " ");
                    list.remove(second);
                } else if (firstEnd.equalsIgnoreCase(secondStart)) {
                    builder.append(" ").append(second);
                    list.remove(second);
                } else {
                    list.remove(second);
                    list.add(second);
                    count++;
                    if (count > 1000) {
                        break;
                    }
                }
            }
            builderList.add(builder);
        }
        return builderList.stream().max(Comparator.comparingInt(StringBuilder::length)).get();
    }

}

