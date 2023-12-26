package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Jack",5.0);
        grades.put("Jac",1.0);
        grades.put("Jask",2.0);
        grades.put("John",3.0);
        grades.put("jill",4.0);

    }
}
