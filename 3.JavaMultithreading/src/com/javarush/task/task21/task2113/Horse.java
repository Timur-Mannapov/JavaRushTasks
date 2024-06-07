package com.javarush.task.task21.task2113;

public class Horse {

    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    void move() {
        distance += speed * Math.random();
    }

    void print() {
        int dist = (int) Math.floor(distance);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dist; i++) {
            builder.append(".");
        }
        System.out.printf(builder + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
