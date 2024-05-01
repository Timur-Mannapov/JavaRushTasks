package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (reader.ready()) {
                String string = reader.readLine();
                if (string.equalsIgnoreCase("end")) {
                    break;
                }

                String str = string.substring(string.lastIndexOf("t") + 1);
                int index = Integer.parseInt(str);
                map.put(index, string);
            }
        }
        for (String fullName : map.values()) {
            String shortName = fullName.substring(0, fullName.lastIndexOf("."));
            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(fullName));
                 BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(shortName,true))) {
                while (input.available() > 0) {
                    output.write(input.read());
                }
            }

        }

    }
}