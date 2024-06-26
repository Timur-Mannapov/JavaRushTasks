package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
//        if (telNumber.matches("\\+\\d{12}")
//                || telNumber.matches(("\\+\\d+(\\(\\d{3}\\))?\\d+"))
//                || telNumber.matches("\\(\\d{3}\\)\\d{7}")
//                || telNumber.matches("\\d*(\\(\\d{3}\\))?\\d+")) {

            return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");

    }

    public static void main(String[] args) {
        String test =
                "+380501234567 - true\n" +
                        "+38(050)1234567 - true\n" +
                        "(050)1234567 - true\n" +
                        "0(501)234567 - true\n" +
                        "+38)050(1234567 - false\n" +
                        "+38(050)1-23-45-6-7 - false\n" +
                        "050ххх4567 - false\n" +
                        "050123456 - false\n" +
                        "(0)501234567 - false";
        String[] words;
        boolean check;
        for (String s : test.split("\\n")) {
            words = s.split("\\s");
            check = checkTelNumber(words[0]);
            System.out.printf("%-30s\t%b\t%s%n", s, check, check == "true".equals(words[0]) ? "" : "!!!");
        }
    }
}

