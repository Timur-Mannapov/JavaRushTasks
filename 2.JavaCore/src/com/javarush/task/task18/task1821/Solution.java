package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<Character, Integer> map = new TreeMap<>();
        FileReader reader = new FileReader(args[0]);
        while (reader.ready()) {
            char ch = (char) reader.read();
            if (map.containsKey(ch)) {
                map.put(ch,map.get(ch) + 1);
            } else {
                map.put(ch,1);
            }
        }
        for (Map.Entry<Character, Integer> set : map.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
        }
        reader.close();
    }
}
