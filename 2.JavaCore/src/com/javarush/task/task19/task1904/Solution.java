package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
                String str = fileScanner.nextLine();
                String[] array = str.split(" ");
                String lastName = array[1];
                String firstName = array[2];
                String middleName = array[0];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;
            try {
                birthDate = dateFormat.parse(array[3] + "/" + array[4] + "/" + array[5]);
            } catch (ParseException e) {

            }

                Person person = new Person(lastName,firstName,middleName,birthDate);


                return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
