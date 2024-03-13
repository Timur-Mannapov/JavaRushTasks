package com.javarush.task.task15.task1530;

public class TeaMaker extends DrinkMaker{


    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }
    void putIngredient() {
        System.out.println("Насыпаем чай");;
    }

    @Override
    void pour() {
        System.out.println("Заливаем кипятком");
    }
}
