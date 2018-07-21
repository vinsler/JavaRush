package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // обьект который десериализует
        File file = new File(fileName); // создаем файл из filename
        FileReader fileReader = new FileReader(file); // создаем fileReader из file
        T outObj = mapper.readValue(fileReader, clazz);
        // Десериализуем в outObj типа T, из clazz через filereader
        return outObj;
    }

    public static void main(String[] args) {

    }
}
