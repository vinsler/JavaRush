package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

// 1. Класс TxtInputStream должен наследоваться от класса FileInputStream.
public class TxtInputStream extends FileInputStream {
    FileInputStream fileInputStream;
      /*
      2. Если в конструктор передан txt-файл, TxtInputStream должен вести себя, как обычный FileInputStream.
      3. Если в конструктор передан не txt-файл, должно быть выброшено исключение UnsupportedFileNameException.
      */

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String subs = fileName.substring(fileName.length()-4, fileName.length());
        //System.out.println(subs);
        if (!".txt".equals(subs)) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
/*        String fileName = "brigada.txt";
        String subs = fileName.substring(fileName.length()-3, fileName.length());
        System.out.println(subs);*/
    }
}

