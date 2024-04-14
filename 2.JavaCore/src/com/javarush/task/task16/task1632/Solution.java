package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.addAll(Arrays.asList(new myThread1(),new myThread2(),new myThread3(), new myThread4(), new myThread5()));
    }
    public static void main(String[] args) {


    }

    public static class myThread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class myThread2 extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class myThread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException ignore) {

            }
        }
    }

    public static class myThread4 extends Thread implements Message {

        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class myThread5 extends Thread {
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int sum = 0;
                while (true) {
                    String string = reader.readLine();
                    if (string.equals("N")) {
                        break;
                    }
                    sum = sum + Integer.parseInt(string);
                }
                System.out.println(sum);
            } catch (IOException e) {

            }
        }
    }
}