package com.javarush.task.task18.task1803;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        byte[] bytes = Files.readAllBytes(Path.of(new Scanner(System.in).nextLine()));
        HashMap<Byte, Integer> map = IntStream.range(0, bytes.length).boxed()
                .collect(Collectors.toMap(i -> bytes[i], i -> 1, Integer::sum, HashMap::new));
        map.entrySet().stream().filter(pair -> Objects.equals(pair.getValue(),Collections.max(map.values())))
                .forEach(pair -> System.out.print(pair.getKey() + " "));
    }









    public static void main1(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream input = new FileInputStream(bufferedReader.readLine())) {
            ArrayList<Integer> list = new ArrayList<>();
            while (input.available() > 0) {
                list.add(input.read());
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (Integer i : list) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            int maxValue = Collections.max(map.values());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }
}
