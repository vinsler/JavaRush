package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);


        switch (args[0]){
            // 4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
            case "-e": {
                while (fileInputStream.available() > 0){
                    int i = fileInputStream.read();
                    i++;
                    fileOutputStream.write(i);
                }
                fileInputStream.close();
                fileOutputStream.close();
                break;
            }
            // 5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
            case  "-d": {
                while (fileInputStream.available() > 0){
                    int i = fileInputStream.read();
                    i--;
                    fileOutputStream.write(i);
                }
                fileOutputStream.close();
                fileInputStream.close();
                break;
            }
        }
    }

}
