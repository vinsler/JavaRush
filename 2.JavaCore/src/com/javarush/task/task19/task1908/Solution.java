package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        StringBuffer stringBuffer = new StringBuffer();

        //FileReader fileReader = new FileReader(fileName1); // "c:/tmp/1.txt");//
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        while (bufferedReader.ready()) {
            int i = bufferedReader.read();
            stringBuffer.append((char)i);
        }
        bufferedReader.close();

       /* while (fileReader.ready()){
            int i = fileReader.read();
            stringBuffer.append((char)i);
        }
        fileReader.close();*/
        //System.out.println(stringBuffer);

        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher m = p.matcher(stringBuffer);

        //FileWriter fileWriter = new FileWriter(fileName2); // "c:/tmp/2.txt");// +
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String str = "";
        while (m.find()) {
            //System.out.print(m.group() + " ");
            str += m.group() + " ";
        }
        bufferedWriter.write(str);
        //System.out.println(str);

        bufferedWriter.close();
    }
}
