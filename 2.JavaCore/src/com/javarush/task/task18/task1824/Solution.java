package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args)  {
        String str = null;
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while ((str = reader.readLine()) != null) {
                    FileReader fileReader = new FileReader(str);
                    fileReader.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(str);

        }
        catch (IOException e) {

        }
    }
}