package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        FileInputStream file1In = new FileInputStream(filename1); // "c:/tmp/fr1.txt");//
        FileOutputStream file2Out = new FileOutputStream(filename2); // "c:/tmp/fr2.txt");//

        byte[] buffer = new byte[file1In.available()];

        file1In.read(buffer);

        for (int i = buffer.length; i > 0; i--){
            byte tbyte = buffer[i - 1];
            file2Out.write(tbyte);

            //System.out.print(buffer[i-1] + " ");
        }
        //System.out.println();
        file1In.close();
        file2Out.close();

    }
}
