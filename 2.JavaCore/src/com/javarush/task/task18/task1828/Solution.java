package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countString = 0;
        String forString = "";

        if (args[0].equals("-u")) {
            forString =
                    TrimString(args[1], 8) +
                            TrimString(args[2], 30) +
                            TrimString(args[3], 8) +
                            TrimString(args[4], 4);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        switch (args[0]) {
            case "-u" : {
                DoAllParsers(args[0], args[1], filename, forString);
                break;
            }
            case "-d" : {
                DoAllParsers(args[0], args[1], filename, forString);
                break;
            }
        }
    }

    private static void DoAllParsers(String args0, String args1, String mfilename, String mforString) throws IOException {
        String strArr[] = new String[50];
        int cx = 0;
        String str = "";

        FileInputStream fileInputStream = new FileInputStream(mfilename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        while ((str = reader.readLine()) != null) {
            String ttl = str.substring(0, 8).trim();
            if (ttl.equals(args1)) {
                if (args0.equals("-u")) {
                    strArr[cx] = mforString;
                } else if (args0.equals("-d")){
                    cx--;
                }
            } else {
                strArr[cx] = str;
            }
            cx++;
        }
        reader.close();

        FileOutputStream fileOutputStream = new FileOutputStream(mfilename);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        for (int i = 0; i < cx; i++) {
            writer.write(strArr[i]);
            if (i + 1 < cx) {
                writer.newLine();
            }
        }
        writer.close();
    }

    private static String TrimString(String arg, int argslength){
        String tmp = arg;
        if (arg.length() < argslength){
            while (tmp.length() < argslength){
                tmp += " ";
            }
        }
        else if (arg.length() > argslength ) {
            tmp = tmp.substring(0, argslength);
        }
        return tmp;
    }

}
