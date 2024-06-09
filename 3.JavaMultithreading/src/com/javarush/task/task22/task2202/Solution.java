package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String result = null;
        try {
            if ((string == null) || (string.split(" ").length < 5)) {
                throw new TooShortStringException();
            }
            result = string.substring(string.indexOf(" ") + 1);
        } catch (TooShortStringException e) {

        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
