package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String string = url.substring(url.lastIndexOf("?")+1);
        String[] split = string.split("&");
        String[] afterSplit = new String[split.length*2];
        for (int i = 0; i < split.length; i++) {
            String[] thirdArray = split[i].split("=");
            afterSplit[i*2] = thirdArray[0];
            afterSplit[i*2+1] = thirdArray[1];
        }
        for (String s : afterSplit) {
            System.out.println(s);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
