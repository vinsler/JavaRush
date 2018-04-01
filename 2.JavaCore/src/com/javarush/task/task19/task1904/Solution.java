package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }


        public Person read() throws IOException, ParseException {
            ArrayList <String> strarr = new ArrayList<>();

            strarr.add(fileScanner.next());
            strarr.add(fileScanner.next());
            strarr.add(fileScanner.next());

            ArrayList <Integer> intake = new ArrayList<Integer>();

            intake.add(fileScanner.nextInt());
            intake.add(fileScanner.nextInt() - 1);
            intake.add(fileScanner.nextInt() - 1900);

            return new Person(strarr.get(1),strarr.get(2),strarr.get(0), new Date(intake.get(2), intake.get(1), intake.get(0)));

            /*String str = fileScanner.nextLine();
            ArrayList <String> strarr = new ArrayList<>();

            int len = 0;
            String sdate = "";

            // Иванов Иван Иванович 31 12 1950

            for (int i = 0; i < 6; i++){
                if (i < 3) {
                    strarr.add(str.substring(len, str.indexOf(32, len)));
                }
                else {
                    if (i != 5) {
                        sdate += str.substring(len, str.indexOf(32, len)) + ".";
                    }
                    else {
                        sdate += str.substring(len, str.length());
                        strarr.add(sdate);
                    }
                }

                len = str.indexOf(32, len) + 1;
            }

            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(strarr.get(3));
*/
        }

        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
