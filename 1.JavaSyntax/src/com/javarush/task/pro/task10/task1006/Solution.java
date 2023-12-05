package com.javarush.task.pro.task10.task1006;

/* 
Кто тут наследник?
*/

public class Solution {
    public static void main(String[] args) {
        ElectricCar electric = new ElectricCar();
        System.out.println(electric);
        GasCar gas  =new GasCar();
        System.out.println(gas);
        HybridCar hybrid = new HybridCar();
        System.out.println(hybrid);
    }
}
