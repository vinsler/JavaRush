package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException
        {
            throw new NotSerializableException("what are fuck are you afrade?");
        }
        private void readObject(ObjectInputStream in) throws IOException
        {
            throw new NotSerializableException("what are fuck are you afrade?");
        }

    }

    public static void main(String[] args) {

    }
}
