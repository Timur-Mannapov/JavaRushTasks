package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
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
        String[] strings = builder.toString().split(" ");
        String znak = strings[1];
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[2]);
        switch (znak) {
            case "+":
                System.out.printf("%d %s %d = %d",a,znak,b,a+b);
                break;
            case "-":
                System.out.printf("%d %s %d = %d",a,znak,b,a-b);
                break;
            case "*":
                System.out.printf("%d %s %d = %d",a,znak,b,a*b);
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

