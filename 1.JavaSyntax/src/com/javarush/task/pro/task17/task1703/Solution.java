package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;

/* 
Космическая одиссея ч.1
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        Astronaut cat = new Cat();
        astronauts.add(cat);
        Astronaut dog = new Dog();
        astronauts.add(dog);
        Astronaut human = new Human();
        astronauts.add(human);
        Astronaut human1 = new Human();
        astronauts.add(human1);
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}
