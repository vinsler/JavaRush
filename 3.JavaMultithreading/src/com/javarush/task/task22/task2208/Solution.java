package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {

    }

    // {name=Ivanov, country=Ukraine, city=Kiev, age=null}
    // name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'

    public static String getQuery(Map<String, String> params) {
        if (params != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry <String, String> pair : params.entrySet()) {
                if (pair.getValue() != null){
                    sb.append(String.format("%s = '%s' and ", pair.getKey(), pair.getValue()));
                }
            }
            if (sb.length() != 0) {
                sb.delete(sb.length() - 5, sb.length());
            }
            return sb.toString();
        }
        return null;
    }
}
