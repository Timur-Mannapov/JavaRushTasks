package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        {

        }
    }

    public static CanFly result;

    public static void reset() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        if (string.equals("helicopter")) {
            result = new Helicopter();
        } else if (string.equals("plane")) {
            int pass = Integer.parseInt(reader.readLine());
            result = new Plane(pass);
        }
        reader.close();
    }
}
