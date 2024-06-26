package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (bufferedReader.ready()) {
                FileInputStream reader = new FileInputStream(bufferedReader.readLine());
                int bite = reader.available();
                if (bite < 1000) {
                    throw new DownloadException();
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
