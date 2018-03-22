package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> lst = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        ArrayList<Integer> lst3 = new ArrayList<>();
        ArrayList<Integer> lst4 = new ArrayList<>();
        
        
        for (int i = 0; i < 20; i++)
        {
            lst.add(Integer.parseInt(reader.readLine()));
            
            if (lst.get(i) % 3 == 0) 
            {
                lst2.add(lst.get(i));
            }
            
            if (lst.get(i) % 2 == 0)
            {
                lst3.add(lst.get(i));
            }
            
            if (!(lst.get(i) % 3 == 0 || lst.get(i) % 2 == 0))
            {
                lst4.add(lst.get(i));
            }
        }
        
        printList(lst2);
        printList(lst3);
        printList(lst4);
    }

    public static void printList(List<Integer> list) {
        
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
