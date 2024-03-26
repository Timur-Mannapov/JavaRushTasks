package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor> {
    Comparator<JavaRushMentor> comparator = new Comparator<JavaRushMentor>() {
        @Override
        public int compare(JavaRushMentor mentor1, JavaRushMentor mentor2) {
            return mentor1.getName().length() - mentor2.getName().length();
        }
    };

    @Override
    public int compare(JavaRushMentor o1, JavaRushMentor o2) {
        return o1.getName().length() - o2.getName().length();
    }
}

