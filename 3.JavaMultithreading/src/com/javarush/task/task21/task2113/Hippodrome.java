package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse horse = horses.stream().max(Comparator.comparing(Horse::getDistance)).get();
        return horse;
    }

    public void printWinner() {
        System.out.println("Winner is "+ getWinner().name + "!");
    }


    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horsesGame = new ArrayList<>();

        game = new Hippodrome(new ArrayList<Horse>(){{
            add(new Horse("AA",3,0));
            add(new Horse("BB",3,0));
            add(new Horse("CC",3,0));
        }});
        game.run();
        game.printWinner();
    }
}
