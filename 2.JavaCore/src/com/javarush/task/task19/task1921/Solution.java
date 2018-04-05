package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        ArrayList <String> str = new ArrayList<>(); // просто в условии 3 строки :)))

        while (reader.ready()) {
            str.add(reader.readLine());
        }
        reader.close();

        for (byte i = 0; i < str.size(); i++){

            Pattern pattern = Pattern.compile("(^[а-яА-Я\\W]+)");
            Matcher matcher = pattern.matcher(str.get(i));
            matcher.find();
            String sname = matcher.group().trim();

            pattern = Pattern.compile("(\\d+)");
            matcher = pattern.matcher(str.get(i));
            String [] strdate = new String[3];
            byte cx = 0;
            while (matcher.find()) {
                strdate[cx] = matcher.group();
                cx++;
            }
            LocalDate specificDate =
                    LocalDate.of(Integer.parseInt(strdate[2]), Integer.parseInt(strdate[1]), Integer.parseInt(strdate[0]));
            Date date = new Date();
            date = java.sql.Date.valueOf(specificDate);
            PEOPLE.add(new Person(sname, date));
        }





    }
}
