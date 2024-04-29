package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws  IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileWriter fileOne = new FileWriter(reader.readLine());
            FileReader fileTwo = new FileReader(reader.readLine());
            BufferedReader readerTwo = new BufferedReader(fileTwo);
            FileReader fileThree = new FileReader(reader.readLine());
            BufferedReader readerThree = new BufferedReader(fileThree);
            while (readerTwo.ready()) {
                fileOne.write(readerTwo.readLine());
            }
            while (readerThree.ready()) {
                fileOne.write(readerThree.readLine());
            }
            fileOne.close();
            fileTwo.close();
            fileThree.close();
        }
    }
}
