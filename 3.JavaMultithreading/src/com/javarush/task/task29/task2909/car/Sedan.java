package com.javarush.task.task29.task2909.car;

import lombok.Getter;

@Getter
public class Sedan extends Car{
    private final int MAX_SEDAN_SPEED = 120;

    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

}
