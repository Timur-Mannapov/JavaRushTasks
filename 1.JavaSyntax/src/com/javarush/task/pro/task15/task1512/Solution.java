package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();
        String reversedResult = new StringBuilder(result).reverse().toString();
        outputStream.reset();
        outputStream.writeBytes(reversedResult.getBytes());
        System.out.println(outputStream);

//        StringBuilder resultReverse = new StringBuilder(result);
//        String newResult = String.valueOf(resultReverse.reverse());
//        System.out.println(newResult);
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}