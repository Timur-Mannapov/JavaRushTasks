package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(input.readLine()))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            String tag = args[0];
            Document document = Jsoup.parse(builder.toString(),  "", Parser.xmlParser());
            Elements elements = document.select(tag);
            for (Element element : elements) {
                System.out.println(element);
            }
        }

    }
}
