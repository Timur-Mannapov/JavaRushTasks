package com.javarush.task.task29.task2909.human;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Setter
@Getter
public class University {
    private List<Student> students = new ArrayList<>();

    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        return students.stream()
                .filter(student -> student.getAverageGrade() == averageGrade)
                .findFirst()
                .orElseThrow();
    }

    public Student getStudentWithMaxAverageGrade() {

        return students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .orElseThrow();
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream()
                .min(Comparator.comparingDouble(Student::getAverageGrade))
                .orElseThrow();
    }

    public void expel(Student student){
        students.remove(student);
    }
}