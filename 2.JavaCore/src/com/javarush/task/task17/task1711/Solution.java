package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat output = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        if (args[i + 1].equalsIgnoreCase("ж")) {
                            person = Person.createFemale(args[i], input.parse(args[i + 2]));
                        } else if (args[i + 1].equalsIgnoreCase("м")) {
                            person = Person.createMale(args[i], input.parse(args[i + 2]));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        int index = Integer.parseInt(args[i]);
                        if (index >= 0 && index < allPeople.size()) {
                            person = allPeople.get(index);
                            person.setName(args[i + 1]);
                            if (args[i + 2].equalsIgnoreCase("ж")) {
                                person.setSex(Sex.FEMALE);
                            } else if (args[i + 2].equalsIgnoreCase("м")) {
                                person.setSex(Sex.MALE);
                            }
                            person.setBirthDate(input.parse(args[i + 3]));
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        if (index >= 0 && index < allPeople.size()) {
                            person = allPeople.get(index);
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDate(null);
                            allPeople.set(index, person);
                        }
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        if (index >= 0 && index < allPeople.size()) {
                            person = allPeople.get(index);
                            String sex = "";
                            if (person.getSex().equals(Sex.MALE)) {
                                sex = "м";
                            } else if (person.getSex().equals(Sex.FEMALE)) {
                                sex = "ж";
                            }
                            System.out.println(person.getName() + " " + sex + " " + output.format(person.getBirthDate()));
                        }
                    }
                }
                break;
        }
    }
}
