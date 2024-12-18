package com.javarush.task.task29.task2912;

public class FileLogger extends AbstractLogger implements Logger {
    public FileLogger(int level) {
        super(level);
    }
    @Override
    public void info(String message) {
        super.info("Logging to file: " + message);
    }
}