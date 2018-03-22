package com.javarush.task.task09.task0921;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }


    public static void readData() {


        LinkedList<Integer> list = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true)
            {
                list.add(Integer.parseInt(reader.readLine()));
            }

        } catch (IOException e) {

            System.out.println(e);
            e.printStackTrace();
        }
        catch (NumberFormatException e)
        {
            for (int i : list )
            {
                System.out.println(i);
            }
        }


    }
}
