package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =reader.readLine(); // "c:/tmp/2.txt"; //
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            sb.append(bufferedReader.readLine());
        }
        bufferedReader.close();

        StringBuilder result = getLine(sb.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        Arrays.sort(words);

        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String str = "";
        int [] offCount = new int[words.length];
        int i = 0, j = 0, cx = 0;

        if (words == null || words.length == 0 || words.length == 1) {
            return res;
        }

        while (true) {
            if (offCount[i] != 6) {
                sb.append(words[i].charAt(words[i].length() - 1));
            }
            while (true) {
                if (offCount[j] != 6) {
                    str = String.valueOf(words[j].charAt(0)).toLowerCase();
                    if (sb.toString().equals(str.toLowerCase())) {
                        cx++;
                        if (cx != words.length - 1) {
                            res.append(words[i] + " ");
                            offCount[i] = 6;
                            i = j - 1;
                            j = 0;
                            sb.setLength(0);
                        } else {
                            res.append(words[i] + " ");
                            res.append(words[j] + " ");
                            offCount[i] = 6;
                            offCount[j] = 6;
                            i = words.length - 1;
                        }
                        break;
                    }
                }
                j++;
                if (j == words.length) {
                    res.append(words[i] + " ");
                    offCount[i] = 6;
                    break;
                }
            }
            i++;
            if (i == words.length || j == words.length) {
                break;
            }
        }

        for (int k = 0; k < offCount.length ; k++) {
            if (offCount[k] != 6) {
                res.append(words[k] + " ");
            }
        }

        res.delete(res.length() - 1, res.length());
        return res;
    }
}
