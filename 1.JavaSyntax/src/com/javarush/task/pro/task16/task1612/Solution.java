package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
    Set<LocalDateTime> set = new HashSet<>();
        for (LocalDate date : sourceMap.keySet()) {
            for (LocalTime time : sourceMap.get(date)) {
                set.add(LocalDateTime.of(date,time));
            }
        }
        return set;
    }
    static Set<LocalDateTime> convert1(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> set = new HashSet<>();
//        Collection<List<LocalTime>> values = sourceMap.values();
//        Set<LocalDate> localDates = sourceMap.keySet();

        Set<Map.Entry<LocalDate, List<LocalTime>>> entries = sourceMap.entrySet();
        for (Map.Entry<LocalDate, List<LocalTime>> entry : entries) {
            for (LocalTime time : entry.getValue()) {
                LocalDateTime localDateTime = LocalDateTime.of(entry.getKey(), time);
                set.add(localDateTime);
            }
        }
        return set;

    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}