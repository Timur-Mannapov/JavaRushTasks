package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    int x;
    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        BinaryRepresentationTask binaryRepresentationTask = new BinaryRepresentationTask(b);
        binaryRepresentationTask.fork();
        if (b > 0) {
            return binaryRepresentationTask.join() + result;
        }
        return result;


    }
}
