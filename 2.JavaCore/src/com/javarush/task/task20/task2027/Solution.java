package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }



    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> result = new ArrayList<>();
        int hor = crossword[0].length;
        int ver = crossword.length;

        outer:
        for (String s : words) {
            //по горизонтали
            for (int i = 0; i < ver; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hor; j++)
                    sb.append((char) crossword[i][j]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(horLine.indexOf(s), i);
                    word.setEndPoint(horLine.indexOf(s) + s.length() - 1, i);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(hor - horReverse.indexOf(s) - 1, i);
                    word.setEndPoint(hor - horReverse.indexOf(s) - s.length(), i);

                    result.add(word);
                    continue outer;
                }
            }
            //по вертикали
            for (int i = 0; i < hor; i++) {
                StringBuilder sb = new StringBuilder();
                for (int[] aCrossword : crossword)
                    sb.append((char) aCrossword[i]);

                String horLine = sb.toString();
                if (horLine.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, horLine.indexOf(s));
                    word.setEndPoint(i, horLine.indexOf(s) + s.length() - 1);

                    result.add(word);
                    continue outer;
                }
                String horReverse = sb.reverse().toString();
                if (horReverse.contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i, ver - horReverse.indexOf(s) - 1);
                    word.setEndPoint(i, ver - s.length() - horReverse.indexOf(s));

                    result.add(word);
                    continue outer;
                }
            }

            //по диагонали вправо
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp < hor) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp++;
                    }
                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j + horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j + horLine.indexOf(s) + s.length() - 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp - 1 - horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp - horReverse.indexOf(s) - s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }

            //по диагонали влево
            for (int i = 0; i < ver; i++) {
                for (int j = hor - 1; j >= 0; j--) {
                    int iTemp = i;
                    int jTemp = j;
                    StringBuilder sb = new StringBuilder();
                    while (iTemp < ver && jTemp >= 0) {
                        sb.append((char) crossword[iTemp][jTemp]);
                        iTemp++;
                        jTemp--;
                    }

                    String horLine = sb.toString();
                    if (horLine.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(j - horLine.indexOf(s), i + horLine.indexOf(s));
                        word.setEndPoint(j - horLine.indexOf(s) - s.length() + 1, i + horLine.indexOf(s) + s.length() - 1);

                        result.add(word);
                        continue outer;
                    }
                    String horReverse = sb.reverse().toString();
                    if (horReverse.contains(s)) {
                        Word word = new Word(s);
                        word.setStartPoint(jTemp + 1 + horReverse.indexOf(s), iTemp - 1 - horReverse.indexOf(s));
                        word.setEndPoint(jTemp + horReverse.indexOf(s) + s.length(), iTemp - horReverse.indexOf(s) - s.length());

                        result.add(word);
                        continue outer;
                    }
                }
            }
        }

        return result;
    }

//    public static List<Word> detectAllWords2(int[][] crossword, String... words) {
//        ArrayList<Word> result = new ArrayList<>();
//        for (String word : words) {
//            for (int i = 0; i < crossword.length; i++) {
//                for (int j = 0; j < crossword[i].length; j++) {
//                    if (word.charAt(0) == crossword[i][j]) {
//                        int endWord[] = aroundWorld2(crossword,i,j,word);
//                        if (endWord != null) {
//                            Word detectedWord = new Word(word);
//                            detectedWord.setStartPoint(i,j);
//                            detectedWord.setEndPoint(endWord[0],endWord[1]);
//                            result.add(detectedWord);
//                        }
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }



//    public static int[] aroundWorld2(int[][] crossword, int startX, int startY, String word) {
//        int endX = 0;
//        int endY = 0;
//        if (startX < 0 || startY < 0 || startX >= crossword.length || startY >= crossword[startX].length) {
//            return null;
//        }
//        if (startX + word.length() > crossword.length || startY + word.length() > crossword[startX].length) {
//            return null;
//        }
//        if (word.charAt(1) == crossword[startX + 1][startY]) {
//            endX = word.length() + startX;
//            endY = startY;
//        } else if (word.charAt(1) == crossword[startX + 1][startY + 1]) {
//            endX = word.length() + startX;
//            endY = word.length() + startY;
//        } else if (word.charAt(1) == crossword[startX][startY + 1]) {
//            endX = startX;
//            endY = startY + word.length();
//        } else if (word.charAt(1) == crossword[startX + 1][startY - 1]) {
//            endX = startX + word.length();
//            endY = startY - word.length();
//        } else if (word.charAt(1) == crossword[startX - 1][startY + 1]) {
//            endX = startX - word.length();
//            endY = startY + word.length();
//        } else if (word.charAt(1) == crossword[startX][startY - 1]) {
//            endX = startX;
//            endY = startY - word.length();
//        } else if (word.charAt(1) == crossword[startX - 1][startY]) {
//            endX = startX - word.length();
//            endY = startY;
//        } else if (word.charAt(1) == crossword[startX - 1][startY - 1]) {
//            endX = startX - word.length();
//            endY = startY - word.length();
//        }
//        int[] result = new int[2];
//        result[0] = endX;
//        result[1] = endY;
//        return result;
//    }

}
