package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("D:/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("D:/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("D:/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        File file = new File(String.valueOf(Paths.get(fileName)));
        Properties properties = new Properties();
        try {
            if (fileName.substring(fileName.lastIndexOf(".") + 1).equals("xml")){
                properties.loadFromXML(new FileInputStream(file));
            } else {
                properties.load(new FileReader(file));
            }
        } catch (IOException e) {
            return new Properties();
        }
        return properties;
    }
}
