package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        while (bufferedReader.ready()) {
            String strLine = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("\\S*\\d+\\S*");
            Matcher matcher = pattern.matcher(strLine);

            String strFind = "";
            while (matcher.find()) {
                strFind += matcher.group() + " ";
            }
            fileWriter.write(strFind);
        }
        bufferedReader.close();
        fileWriter.close();
    }
}
