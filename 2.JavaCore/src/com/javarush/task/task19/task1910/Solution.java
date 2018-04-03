package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

// запятая (,) точка с запятой (;) двоеточие (:) точка (.)
// восклицательный (!) вопросительный (?) многоточие (…) тире (—)
// ,;:.!?-

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameForRead = reader.readLine();
        String fileNameForWrite = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameForRead)); // "c:/tmp/1.txt")); //
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameForWrite)); // "c:/tmp/2.txt")); //

        while (bufferedReader.ready()) {
            String str = bufferedReader.readLine().replaceAll("\\p{Punct}", "");
            System.out.print(str + " ");
            bufferedWriter.write(str);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
