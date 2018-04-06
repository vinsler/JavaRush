package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution { // c:/tmp/1.txt
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuffer stringBuffer = new StringBuffer();

        while (bufferedReader.ready()) {
            stringBuffer.append(bufferedReader.readLine());
            stringBuffer.reverse();
            System.out.println(stringBuffer);
            stringBuffer.delete(0, stringBuffer.length());
        }
        bufferedReader.close();
    }
}
