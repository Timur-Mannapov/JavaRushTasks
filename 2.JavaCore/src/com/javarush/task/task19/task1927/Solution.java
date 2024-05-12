package com.javarush.task.task19.task1927;

import java.io.*;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(console);
        BufferedReader reader= new BufferedReader(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray())));
        int count = 1;
        while (reader.ready()) {
            if (count % 3 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            } else {
                System.out.println(reader.readLine());
            }
            count++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
