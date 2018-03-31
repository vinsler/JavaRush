package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String st = "";

        // 1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
        // 2. Для каждого файла создай нить ReadThread и запусти ее.
        while(!"exit".equals((st = reader.readLine()))){
            ReadThread readThread = new ReadThread(st);
            readThread.start();
            //readThread.join();
        }
    }

    public static class ReadThread extends Thread {

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        String fileN = "";

        // 3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.

        public ReadThread(String fileName) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            fileN = fileName;
            while (fileInputStream.available() > 0) {
                int i = fileInputStream.read();
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                }
                else {
                    map.put(i, map.get(i) + 1);
                }
            }
            fileInputStream.close();
        }

        public void run() {
            int maxv = 1;
            int cxByte = 0;

            for (Map.Entry <Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() > maxv) {
                    maxv = pair.getValue();
                    cxByte = pair.getKey();
                }
            }
            resultMap.put(fileN, cxByte);
        }

    }
}
