package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.charset.Charset;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        if (args[0].equals("-c")) {

            FileInputStream fileInputStream = new FileInputStream(filename);
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String str = "";
            TreeSet <Long> set = new TreeSet<>();

            while ((str = reader.readLine()) != null) {
                set.add(Long.parseLong(str.substring(0, 8).trim()));
            }
            reader.close();

            FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            StringBuffer st1 = new StringBuffer(); // 1.txt

            Long i1 = set.last() + 1;
            String si1 = i1.toString();
            if (i1.toString().length() < 8) {
                si1 = TrimString(i1.toString(), 8);
            }

            st1.append(si1 +
                            TrimString(args[1], 30) +
                            TrimString(args[2], 8)+
                            TrimString(args[3], 4));
            writer.newLine();
            writer.write(st1.toString());
            writer.close();
        }
    }

    private static String TrimString(String args, int argslength){
        String tmp = args;
        if (args.length() < argslength){
            while (tmp.length() < argslength){
                tmp += " ";
            }
        }
        else if (args.length() > argslength ) {
            tmp = tmp.substring(0, argslength);
        }
        return tmp;
    }

}
