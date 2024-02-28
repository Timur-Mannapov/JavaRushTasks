package com.javarush.task.task14.task1421;

public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Singleton");
    }

    public static Singleton getInstance() {
        return instance;
    }
}
