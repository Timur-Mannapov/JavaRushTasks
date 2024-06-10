package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {
            if ((string == null) || (string.split(" ").length < 4)) {
                throw new TooShortStringException();
            } else {
                String stringSpace = string.substring(string.indexOf(" ") + 1);
                String[] split = stringSpace.split(" ");
                String format = "%s %s %s %s";
                return String.format(format, split[0] , split[1] , split[2] , split[3]);

            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
