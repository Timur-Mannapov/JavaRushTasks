package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student>{
    Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return  student2.getAge() - student1.getAge();
        }
    };

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }
}
