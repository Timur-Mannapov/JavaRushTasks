package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        LinkedHashMap<Integer, Product> map = new LinkedHashMap<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String fileName = input.readLine();
        input.close();
        if (args.length > 0) {
            String operation = args[0];
            int ID = Integer.parseInt(args[1]);

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String string;
                while ((string = reader.readLine()) != null) {
                    int mapID = Integer.parseInt(string.substring(0, 8).trim());
                    String mapProductName = string.substring(8, 38).trim();
                    String mapPrice = string.substring(38, 46).trim();
                    String mapQuantity = string.substring(46).trim();
                    map.put(mapID, new Product(mapID, mapProductName, mapPrice, mapQuantity));
                }

                switch (operation) {
                    case ("-u"):
                        String productName = args[2];
                        String price = args[3];
                        String quantity = args[4];
                        map.put(ID, new Product(ID, productName, price, quantity));
                        break;
                    case ("-d"):
                        map.remove(ID);
                        break;
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Product product : map.values()) {
                    writer.write(product.toString());
                    writer.newLine();
                }
            }

        }
    }

    static class Product {
        private int ID;
        private String product;
        private String price;
        private String quantity;

        public Product(int ID, String product, String price, String quantity) {
            this.ID = ID;
            this.product = product;
            this.price = price;
            this.quantity = quantity;
        }

        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s",ID,product,price,quantity);
        }
    }
}


