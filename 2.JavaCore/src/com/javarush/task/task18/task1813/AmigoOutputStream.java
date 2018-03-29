package com.javarush.task.task18.task1813;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    FileOutputStream fileOutputStream;
    // 2. Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
    public static String fileName = "C:/tmp/result.txt";

    /* 3. Класс AmigoOutputStream должен принимать в конструкторе обьект типа FileOutputStream.
     public FileOutputStream(String name) throws FileNotFoundException {
         this(name != null ? new File(name) : null, false);
     }*/
    public AmigoOutputStream(FileOutputStream filen) throws FileNotFoundException {
        super(filen.toString());
    }

    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    public void flush() throws IOException {
        fileOutputStream.flush();

    }

    public void close() throws IOException {
        fileOutputStream.flush();
        // перевод строки в байты
        byte[] buffer = "JavaRush © All rights reserved.".getBytes();
        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
