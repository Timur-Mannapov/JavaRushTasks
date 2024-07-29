package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State currentState = thread.getState();
        System.out.println(currentState);
        while (true) {
            State newState = thread.getState();
            if (currentState != newState) {
                System.out.println(newState);
                currentState = newState;
            } else if (newState == State.TERMINATED) {
                break;
            }
        }
    }
}
