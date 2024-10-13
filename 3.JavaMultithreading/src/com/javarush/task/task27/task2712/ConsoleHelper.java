package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
            return reader.readLine();
        }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> list = new ArrayList<>();
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        ConsoleHelper.writeMessage("Выберите блюдо");
        while (true) {
            String dishString = ConsoleHelper.readString().trim();

            if ("exit".equals(dishString)) {
                break;
            }
            try {
                Dish dish = Dish.valueOf(dishString);
                list.add(dish);
                writeMessage(dishString + " добавлен");
            } catch (Exception e) {
                writeMessage(dishString + " такого блюда нет в меню");
            }
        }
        return list;
    }
}
