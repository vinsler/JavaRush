package com.javarush.task.task06.task0606;

import java.io.*;


/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        
        while (true){
            if (i > 9){
                if ((i % 10) % 2 == 0) even++;
                else odd++;
                i /= 10;
            }
            else {
                if (i % 2 == 0) even++;
                else odd++;
                break;
            }
        }
        
        System.out.println("Even: " + even + " Odd: " + odd);
        //напишите тут ваш код
    }
}
