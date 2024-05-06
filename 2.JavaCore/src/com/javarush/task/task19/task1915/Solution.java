package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);
        StringBuilder builder = new StringBuilder(result);
        String endResult = builder.toString();
        System.out.println(endResult);
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream writer = new FileOutputStream(input.readLine())) {
            writer.write(endResult.getBytes());
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

