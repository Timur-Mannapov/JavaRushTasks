package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);
        StringBuilder builder = new StringBuilder(result);
        String endResult = builder.toString().replaceAll("te","??");
        System.out.println(endResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
