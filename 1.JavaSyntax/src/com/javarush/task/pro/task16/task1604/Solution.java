package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(12,12,2012);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
       String[] strings = new String[]{"Воскресенье","Понедельник","Вторник","Среда","Четверг","Пятница", "Суббота"};
       int day = calendar.get(Calendar.DAY_OF_WEEK)  - 1;
       return strings[day];
}
}
