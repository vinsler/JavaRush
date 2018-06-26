package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0]; // путь к файлу для добавления в архив
        String zipfilename = args[1]; // путь к архиву, в который нужно добавить файл
        // если такой файл уже там есть, то удалить его и положить в папку new/ новый

        Map<String, ByteArrayOutputStream> map = new HashMap<>(); // save zip to tmp
        FileInputStream fis = new FileInputStream(zipfilename);

        try (ZipInputStream forREADzip = new ZipInputStream(fis)) {
            ZipEntry zipEntry;
            while ((zipEntry = forREADzip.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int cx = 0;
                while ((cx = forREADzip.read(buffer)) != -1) {
                    baos.write(buffer, 0, cx);
                }
                map.put(zipEntry.getName(), baos);
            }
        }

        FileOutputStream fos = new FileOutputStream(zipfilename);

        try (ZipOutputStream forWritezip = new ZipOutputStream(fos)) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : map.entrySet()) {
                String str = pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1);
                if (str.equals(Paths.get(filename).getFileName().toString())) {
                    continue;
                }
                forWritezip.putNextEntry(new ZipEntry(pair.getKey()));
                forWritezip.write(pair.getValue().toByteArray());
            }
            ZipEntry zipEntry1 = new ZipEntry("new/" + Paths.get(filename).getFileName().toString());
            forWritezip.putNextEntry(zipEntry1);
            Files.copy(Paths.get(filename), forWritezip);

        }
    }
}
