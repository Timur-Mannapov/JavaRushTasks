package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей Ӏ Java Core: 6 уровень, 13 лекция
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new SleepingThread().join();

        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countdownIndex == 0) {
                        Thread.sleep(10);
                        return;
                    }
                    if (SleepingThread.currentThread().isInterrupted()) {

                        System.out.println("Нить прервана");
                    }
                }
            } catch (InterruptedException ignore) {

            }
        }

        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
