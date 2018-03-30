package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {



        //1. Программа должна считать имя файла с консоли.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine(); // "c:/tmp/data.txt"; //
        reader.close();

        // 2. Создай для файла поток для чтения.
        FileInputStream fileInputStream = new FileInputStream(filename);

        // 3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
        reader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line = "";
        int id = Integer.parseInt(args[0]);

        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++){
                if (line.charAt(i) == ' '){
                    int t = Integer.parseInt(line.substring(0, i));
                    if (id == t){
                        System.out.println(line);
                        break;
                    }
                    break;
                }
            }
        }
        reader.close();
        fileInputStream.close();
    }
}
