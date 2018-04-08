package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File tfile = new File("c:/tmp/tmpf2014.txt");
        InputStream inputStream = new FileInputStream(tfile);
        OutputStream outputStream = new FileOutputStream(tfile);

        Solution savedObject = new Solution(-15);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();

        System.out.println(objectOutputStream);

        Solution xzObject = new Solution(-10);

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Solution loadedObject = (Solution) objectInputStream.readObject();
        objectInputStream.close();

        if (savedObject.string.equals(loadedObject.string)) {
            System.out.println("both strings are equal");
        } else {
            System.out.println("both strings are not equal");
        }

        System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
