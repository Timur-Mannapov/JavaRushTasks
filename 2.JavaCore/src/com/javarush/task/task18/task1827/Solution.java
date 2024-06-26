package com.javarush.task.task18.task1827;

import java.io.*;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            int maxID = 0;
            String str;
            while (reader.ready()) {
                str = reader.readLine();
                int temp = Integer.parseInt(str.substring(0, 8).trim());
                if (maxID < temp) {
                    maxID = temp;
                }
            }
            if (args.length > 0 && args[0].equals("-c")) {
                String productName = String.format("%-30s", args[1]);
                String price = String.format("%-8s", args[2]);
                String quantity = String.format("%-4s", args[3]);
                maxID++;
                writer.write(String.format("\n%-8d%s%s%s", maxID, productName, price, quantity));
            }
        }
    }
}