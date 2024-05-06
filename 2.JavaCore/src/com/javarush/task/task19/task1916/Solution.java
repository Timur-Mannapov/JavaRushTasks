package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileOne = new BufferedReader(new FileReader(input.readLine()));
             BufferedReader fileTwo = new BufferedReader(new FileReader(input.readLine()))) {
            ArrayList<String> listOne = new ArrayList<>();
            ArrayList<String> listTwo = new ArrayList<>();

            while (fileOne.ready()) {
                listOne.add(fileOne.readLine());
            }
            while (fileTwo.ready()) {
                listTwo.add(fileTwo.readLine());
            }
            while (listOne.size() > 0 && listTwo.size() > 0) {
                if (listOne.get(0).equals(listTwo.get(0))) {
                    lines.add(new LineItem(Type.SAME, listOne.get(0)));
                    listOne.remove(0);
                    listTwo.remove(0);
                } else if (listOne.get(1).equals(listTwo.get(0))) {
                    lines.add(new LineItem(Type.REMOVED, listOne.get(0)));
                    listOne.remove(0);
                } else if(listOne.get(0).equals(listTwo.get(1))){
                    lines.add(new LineItem(Type.ADDED,listTwo.get(0)));
                    listTwo.remove(0);
                }
            }
            while (listOne.size() > 0 || listTwo.size() > 0) {
                lines.add(new LineItem(Type.ADDED,listTwo.get(0)));
                listTwo.remove(0);
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
