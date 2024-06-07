package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            if (string == null || string.indexOf("\t") == string.lastIndexOf("\t")) {
                throw new TooShortStringException();
            } else {
                String stringTab = string.substring(string.indexOf("\t") + 1);
                String[] split = stringTab.split("\\t");
                return split[0];
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
