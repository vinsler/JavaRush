package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        List <String> mth = new ArrayList<String> ();
        mth.add("January");
        mth.add("February");
        mth.add("March");
        mth.add("April");
        mth.add("May");
        mth.add("June");
        mth.add("July");
        mth.add("August");
        mth.add("September");
        mth.add("October");
        mth.add("November");
        mth.add("December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        int indM = mth.indexOf(s) + 1;

        System.out.println(s + " is " + indM + " month");
    }
}
