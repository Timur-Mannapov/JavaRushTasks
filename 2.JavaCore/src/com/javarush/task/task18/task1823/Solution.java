package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = input.readLine();
            while(!fileName.equals("exit")) {
                Thread thread = new ReadThread(fileName);
            }

        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws IOException {

        }

        public String getFileName() {
            return fileName;
        }

        public void run() {

            try (BufferedReader input = new BufferedReader(new FileReader(getFileName()))) {

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        {

        }
    }
}
