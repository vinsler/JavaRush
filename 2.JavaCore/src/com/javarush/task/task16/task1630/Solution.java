package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static
    {   //add your code here - добавьте код тут
        //firstFileName и secondFileName.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = reader.readLine(); // вводим имя 1ого файла
            secondFileName = reader.readLine(); // вводим имя 2ого файла
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ------------------------------------------------------------------------------

    public static void main(String[] args) throws InterruptedException {

        systemOutPrintln(firstFileName);    // запускаем введеный 1ый файл в sout
        systemOutPrintln(secondFileName);   // запускаем введенный 2ой файл в sout
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        // создаем переменную f типа ReadFileInterface(описание полей переменной) и
        // выделяем память обьемом ReadFileThread (действия этих полей)
        f.setFileName(fileName); // в переменную f записываем имя filename из метода setFileName
        f.start(); // запускаем нить
        f.join(); // ожидаем окончания нити

        //add your code here - добавьте код тут

        System.out.println(f.getFileContent()); // выводим содержимое файла
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        private String filename;  // вот тут про эту строку ни слова в условии, но без нее хз как запилить
        private String filecontent =""; // про эту так же ни слова, аналог выше

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
                // создаем reader типа буфера новый буфер для чтения
                // (из нового файла для чтения(с новым файлом (имя которого)))
                while (reader.ready()) // пока в reader'е есть что читать
                {
                    filecontent += reader.readLine() + " "; // дописываем это к filecontent
                }
                reader.close(); // закрываем этот ридер
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setFileName(String fullFileName) {
            filename = fullFileName;
        }

        public String getFileContent() {
            return filecontent;
        }
    }

}
