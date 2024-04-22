package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String nameOne = reader.readLine();
            String nameTwo = reader.readLine();

            try (FileReader fileReader = new FileReader(nameOne);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while (bufferedReader.ready()) {
                    allLines.add(bufferedReader.readLine());
                }

            }
            try (FileReader fileReader2 = new FileReader(nameTwo);
                 BufferedReader bufferedReader2 = new BufferedReader(fileReader2)) {
                while (bufferedReader2.ready()) {
                    forRemoveLines.add(bufferedReader2.readLine());
                }

            }
            Solution solution = new Solution();
            solution.joinData();
        }
    }

    public void joinData() throws CorruptedDataException {

        if (new HashSet<>(allLines).containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();

            throw new CorruptedDataException();
        }
    }
}
