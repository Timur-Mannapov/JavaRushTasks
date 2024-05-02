package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine();
            FileReader reader = new FileReader(fileName);
            FileWriter writer = new FileWriter(fileName);
            int ID = 0;
            if (args[0].equals("-c")) {

                String productName = String.format("%30s", args[1]);
                if (productName.equals("+\\S")) {
                    ++ID;
                    String price = String.format("%8s", args[2]);
                    String quantity = String.format("%4s", args[3]);
                    writer.write(ID + productName + price + quantity);
                }
            }
        }
    }
}