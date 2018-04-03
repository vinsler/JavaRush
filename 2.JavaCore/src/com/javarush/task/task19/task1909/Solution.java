package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1)); // "c:/tmp/1.txt")); //
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2)); // "c:/tmp/2.txt")); //

        //StringBuffer stringBuffer = new StringBuffer();

        while (bufferedReader.ready()) {
            bufferedWriter.write(bufferedReader.readLine().replaceAll("[\\.]", "!"));
            //System.out.println();
            //stringBuffer.append(bufferedReader.readLine().replaceAll("[\\.]", "!"));
        }
        bufferedReader.close();

        /*String str = "";
        str = stringBuffer.toString();
        str.replaceAll("[\\.]", "!");*/

        //System.out.println(stringBuffer);

        bufferedWriter.close();
    }
}
