package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream reader = new FileInputStream(args[0]);
             FileOutputStream writer = new FileOutputStream(args[1])) {
            Charset windows = Charset.forName("Windows-1251");
            Charset utf = Charset.forName("UTF-8");

            byte[] buffer = new byte[1000];
            reader.read(buffer);
            String s = new String(buffer,windows);
            buffer = s.getBytes(utf);
            writer.write(buffer);

        }
    }
}
