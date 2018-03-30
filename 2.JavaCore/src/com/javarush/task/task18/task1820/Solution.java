package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

        // 1. Программа должна два раза считать имена файлов с консоли.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 =  reader.readLine(); //"c:/tmp/fr1.txt"; //reader.readLine(); //
        String filename2 =  reader.readLine(); //"c:/tmp/fr2.txt"; //


        // 2. Для первого файла создай поток для чтения. Для второго - поток для записи.

        FileInputStream fileInputStream = new FileInputStream(filename1);
        FileOutputStream fileOutputStream = new FileOutputStream(filename2);

        // Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
       /* Принцип округления:
        3.49 - 3
        3.50 - 4
        3.51 - 4
       -3.49 - -3
       -3.50 - -3
       -3.51 - -4*/
        // 3. Считать числа из первого файла, округлить их и записать через пробел во второй.

        String stra = "";

        while (fileInputStream.available() > 0){
            char ch = (char)fileInputStream.read();

            if (ch != 32 && !(ch==13 || ch ==10)) {
                stra = stra + ch;
            }
            else if(ch == 10 || ch == 13) {
                if (!"".equals(stra)){
                    int i = (int) Math.round(Double.parseDouble(stra));

                    String si = Integer.toString(i);

                    for (int l = 0; l < si.length(); l++){
                        char chx = si.charAt(l);
                        fileOutputStream.write(chx);
                        //System.out.print((char) chx);
                    }
                    //System.out.print(" ");
                    fileOutputStream.write(32);
                    stra = "";
                }

            } else {
                int i = (int) Math.round(Double.parseDouble(stra));

                String si = Integer.toString(i);

                for (int l = 0; l < si.length(); l++){
                    char chx = si.charAt(l);
                    fileOutputStream.write(chx);
                    //System.out.print((char) chx);
                }
                //System.out.print(" ");
                fileOutputStream.write(32);
                stra = "";
            }
        }

        if (stra != "") {
            int i = (int) Math.round(Double.parseDouble(stra));
            String si = Integer.toString(i);
            for (int l = 0; l < si.length(); l++){
                char chx = si.charAt(l);
                fileOutputStream.write(chx);
            }
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
