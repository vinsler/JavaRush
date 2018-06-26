package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        String[] zipfilepart = new String[args.length - 1];
        for (int i = 1; i <= args.length - 1; i++) {
            zipfilepart[i - 1] = args[i];
            //System.out.println(zipfilepart[i - 1] + ":::" + i + " LENGTH " + args.length);
        }
        Arrays.sort(zipfilepart);

        File file = new File(resultFileName);
        if (!file.exists()) {
            Files.createFile(Paths.get(resultFileName));
        }

        FileOutputStream fos = new FileOutputStream((resultFileName));
        ZipInputStream zis;
        ZipEntry ze;
        byte [] buffer = new byte[1024*1024];

        for (String str : zipfilepart) {
            zis = new ZipInputStream(new FileInputStream(str));
            System.out.println(str + " --- ");
            while ((ze = zis.getNextEntry()) != null) {
                fos.write(zis.read(buffer));
                zis.closeEntry();
            }
            System.out.println(ze);
            zis.close();
        }

    }
}
