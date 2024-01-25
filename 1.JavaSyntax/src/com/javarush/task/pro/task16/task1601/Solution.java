package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(94,10,5);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        String dayOfWeek = simpleDateFormat.format(date);

        return switch (dayOfWeek) {
            case "Monday" -> "Понедельник";
            case "Tuesday" -> "Вторник";
            case "Wednesday" -> "Среда";
            case "Thursday" -> "Четверг";
            case "Friday" -> "Пятница";
            case "Saturday" -> "Суббота";
            case "Sunday" -> "Воскресенье";
            default -> "Неизвестный день недели";
        };
    }
}
