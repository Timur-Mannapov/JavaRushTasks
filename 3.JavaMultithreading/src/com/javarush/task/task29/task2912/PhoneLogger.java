package com.javarush.task.task29.task2912;

public class PhoneLogger extends AbstractLogger implements Logger {
    public PhoneLogger(int level) {
        super(level);
    }
    @Override
    public void info(String message) {
        super.info("Call to director: " + message);
    }
}