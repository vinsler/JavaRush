package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader1 = new FileReader(file1); // "c:/tmp/f1.txt");//
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        ArrayList <String> list1 = new ArrayList<String>();
        while (bufferedReader1.ready()){
            list1.add(bufferedReader1.readLine());
        }
        fileReader1.close();

        FileReader fileReader2 = new FileReader(file2); // "c:/tmp/f2.txt"); //
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        ArrayList <String> list2 = new ArrayList<String>();
        while (bufferedReader2.ready()){
            list2.add(bufferedReader2.readLine());
        }
        fileReader2.close();

        int j = 0;
        int i = 0;

        while (true) {

            if (i < list1.size()) {
                if (j < list2.size()) {

                    if (list1.get(i).equals(list2.get(j))) {
                        lines.add(new LineItem(Type.SAME, list1.get(i)));
                        i++;
                        j++;
                    } else {
                        if (j + 1 < list2.size()) {
                            if (list1.get(i).equals(list2.get(j + 1))) {
                                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                                j++;
                            } else {
                                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                                i++;
                            }
                        } else {
                            lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                            i++;
                        }
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                }
            }
            else {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                j++;

            }

            if (i == list1.size() && j == list2.size())
            {
                break;
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

}
