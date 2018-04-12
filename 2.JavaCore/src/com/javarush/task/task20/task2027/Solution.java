package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {

            /*int[][] crossword = new int[][]{
                    {'f', 'd', 'e', 'r', 'l', 'k'},
                    {'u', 's', 'a', 'm', 'e', 'o'},
                    {'l', 'u', 'g', 'r', 'o', 'v'},
                    {'m', 'l', 'p', 'r', 'r', 'h'},
                    {'p', 'o', 'e', 'p', 'j', 'j'},
                    {'t', 'r', 'w', 'e', 'k', 'a'},
                    {'m', 'c', 'n', 's', 's', 'o'},
                    {'z', 'o', 'e', 'f', 'h', 's'}
            };*/

        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        //System.out.println(detectAllWords(crossword, "home", "same").toString());
        System.out.println(detectAllWords(crossword, "jroel").toString()); // "lleess", "sseell"
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List <Word> wordList = new ArrayList<>();
        int [] fw = new int[2];
        int [] fromFV = new int[2];
        int [] fromSV = new int[2];
        int [] sw = new int[] {100, 100};
        int [] gfw = new int[2];

        for (String str : words) {
            wordList.add(new Word(str));
        }

        for (Word wor : wordList) {
            fromFV[0] = 0;
            fromFV[1] = 0;
            int cx = getCount(crossword, wor.text.charAt(0));
            for (int i = 0; i < cx; i++) {
                fw = getFirstWord(crossword, wor.text.charAt(0), fromFV);

                fromFV[0] = fw[0] + 1;
                fromFV[1] = fw[1];

                if (fromFV[0] == crossword[0].length && fromFV[1] != crossword.length) {
                    fromFV[0] = 0;
                    fromFV[1] = fw[1] + 1;
                }

                int bx = getSecondCount(crossword, wor.text.charAt(1), fw);

                fromSV[0] = 0;
                fromSV[1] = 0;
                for (int gsc = 0; gsc < bx; gsc++) {

                    sw = getSecondWord(crossword, wor.text.charAt(1), fw, fromSV);

                    if (sw[0] == 100) {
                        //System.out.println("Второй буквы с позицией " + fw[0] + ":" + fw[1] + " нет");
                    } else {
                        gfw = getFullWord(crossword, wor.text, fw, sw);
                        //System.out.println("Это getFullWord - " + gfw[0] + ":" + gfw[1]);
                        //System.out.println("fw + sw - " + fw[0] + ":" + sw[0]);
                        if (gfw[0] != 100) {
                            wor.setStartPoint(fw[0], fw[1]);
                            wor.setEndPoint(gfw[0], gfw[1]);
                            fromFV[0] = 0;
                            fromFV[1] = 0;
                        } else {
                            fromSV[0] = fw[0] + sw[0] + 1;
                            fromSV[1] = fw[1] + sw[1];

                            if (fromSV[0] == crossword[0].length && fromSV[1] != crossword.length) {
                                fromSV[0] = 0;
                                fromSV[1]  += fromSV[1];
                            }
                        }
                    }

                }
            }
        }
        return wordList;
    }

    public static  int getSecondCount(int[][] crossword, char ch, int[] pos) {
        int  getSC = 0;

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                //System.out.println((char) crossword[i][j] + " <> " + ch + " на позиции:" + pos[0] + "" + pos[1]);
                if (((char)crossword[i][j] == ch) &&
                        (pos[0] == j || pos[0] == j - 1 || pos[0] == j + 1) &&
                        (pos[1] == i || pos[1] == i - 1 || pos[1] == i + 1) &&
                        !(pos[0] == j && pos[1] == i))
                {
                    //System.out.println("GOAL " +getSC);
                    getSC++;
                }
            }
        }
        return getSC;
    }

    public static int getCount(int[][] crossword, char ch){
        int count = 0;
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if ((char)crossword[i][j] == ch) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] getFirstWord(int[][] crossword, char ch, int [] from) {
        int [] getFW = new int[2];

        for (int i = from[1]; i < crossword.length; i++) {
            for (int j = from[0]; j < crossword[0].length; j++) {
                if ((char)crossword[i][j] == ch) {
                    //System.out.println("Найдена первая буква - " + ch + " position " + j +":" + i);
                    getFW[0] = j;
                    getFW[1] = i;
                    return getFW;
                }
                if (i == (crossword.length - 1)) {
                    from[1] = 0;
                }
                if (j == (crossword[0].length - 1)) {
                    from[0] = 0;
                }
            }
        }
        return getFW;
    }

    public static  int[] getSecondWord(int[][] crossword, char ch, int[] pos, int[] from) {
        int [] getSW = new int[]{100, 100};

        for (int i = from[1]; i < crossword.length; i++) {
            for (int j = from[0]; j < crossword[0].length; j++) {
                if (((char)crossword[i][j] == ch) &&
                        (pos[0] == j || pos[0] == j - 1 || pos[0] == j + 1) &&
                        (pos[1] == i || pos[1] == i - 1 || pos[1] == i + 1) &&
                        !(pos[0] == j && pos[1] == i)) //
                {
                    getSW[0] = j - pos[0];
                    getSW[1] = i - pos[1];
                    return getSW;
                }

                if (i == (crossword.length - 1)) {
                    from[1] = 0;
                }
                if (j == (crossword[0].length - 1)) {
                    from[0] = 0;
                }


            }
        }
        return getSW;
    }

    public static int[] getFullWord(int[][] crossword, String str, int[] pos, int[] way){
        int [] result = new int[] {100, 100};
        int cx = 0;

        int i = pos[1], j = pos[0];

        while (cx < str.length()) {
            if (i == crossword.length || j == crossword[0].length || i < 0 || j < 0) {
                //System.out.println("Упс, вышли за границу массива, без трайкетча...");
                return result;
            }
            if ((char) crossword[i][j] != str.charAt(cx)) {
                return result;
            }
            if ( (char) crossword[i][j] == str.charAt(str.length() - 1) && cx == str.length() - 1) {
                result[0] = j;
                result[1] = i;
                return result;
            }
            i += way[1];
            j += way[0];
            cx++;
        }
        return result;
    }



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
}
