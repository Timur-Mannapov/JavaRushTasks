package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName;
            while (!(fileName = input.readLine()).equals("exit")) {
                Thread thread = new ReadThread(fileName);
                thread.start();
            }
            input.close();
        } catch (IOException ignore) {

        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }

        public void run() {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            try (FileReader reader = new FileReader(getFileName())) {
                String fileName = getFileName();
                while (reader.ready()) {
                    int byt = reader.read();
                    map.put(byt, map.getOrDefault(byt, 0) + 1);
                }
                reader.close();
                int max = Integer.MIN_VALUE;
                int maxByte = -1;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        maxByte = entry.getKey();
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, maxByte);
                }
            } catch (IOException ignore) {
            }
        }
    }
}
