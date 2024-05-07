package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = "";
                for (int i = 0; i < parts.length - 3; i++) {
                    name += parts[i] + " ";
                }
                name = name.trim();
                int day = Integer.parseInt(parts[parts.length - 3]);
                int month = Integer.parseInt(parts[parts.length - 2]);
                int year = Integer.parseInt(parts[parts.length - 1]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
                Date date = dateFormat.parse(day + " " + month + " " + year);
                PEOPLE.add(new Person(name, date));
            }

        }
    }
}