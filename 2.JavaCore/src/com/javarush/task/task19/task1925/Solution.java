package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(args[1]);
        String newLine = "";
        while (bufferedReader.ready()) {
            String [] strLine = bufferedReader.readLine().split(" ");
            for (String sti : strLine) {
                if (sti.length() > 6) {
                    newLine += sti + ",";
                }
            }
        }
        fileWriter.write(newLine.substring(0, newLine.length() - 1));
        fileReader.close();
        fileWriter.close();
    }
}

/*public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        String newLine = "";
        while (fileReader.ready()) {
            int i = 0;
            String strLineCh= "";
            while ((i = fileReader.read()) != -1) {
                strLineCh += (char) i;
            }
            Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z]+");
            Matcher matcher = pattern.matcher(strLineCh);

            while (matcher.find()) {
                if (matcher.group().length() > 6){
                    newLine += matcher.group().toString() + ",";
                }
            }
        }
        fileWriter.write(newLine.substring(0, newLine.length() - 1));
        fileReader.close();
        fileWriter.close();
    }
}*/

/*    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(args[1]);

        String newLine = "";
        while (bufferedReader.ready()) {
            String strLine = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("[а-яА-Я]+");
            Matcher matcher = pattern.matcher(strLine);

            while (matcher.find()) {
                if (matcher.group().length() > 6){
                    newLine += matcher.group().toString() + ",";
                }
            }
            fileWriter.write(newLine.substring(0, newLine.length() - 1));
        }
        fileReader.close();
        fileWriter.close();
    }*/
