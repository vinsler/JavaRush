package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine(); // "c:/tmp/1.txt";  //
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();

        while (fileReader.ready()) {
            sb.append(fileReader.readLine() + " ");
        }
        fileReader.close();

        String [] strArr = sb.toString().split(" ");
        System.out.println(sb);
        sb.setLength(0);
        StringBuilder sbGoal = new StringBuilder();

        for (int i = 0; i < strArr.length ; i++) {
            for (int j = strArr.length - 1; j != i ; j--) {
                sb.append(strArr[j]).reverse();
                if (strArr[i].equals(sb.toString())) {
                    Pair pair = new Pair(strArr[i], strArr[j]);
                    Pair rpair = new Pair(strArr[j], strArr[i]);
                    if (!result.contains(pair) && !result.contains(rpair)) {
                        result.add(pair);
                    }
                }
                sb.setLength(0);
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
