package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        double i = 0;
        int count = 0;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) { // бесконечный цикл

            float f = Float.parseFloat(reader.readLine());
            // присваиваем в f введенное число
            
            if (f == -1 && count != 0) // если оно -1 и числа какие-то уже были введены
            {
                System.out.println(i / count); // выводим частное от суммы цифр на их кол-во
                break; // выходим из цикла
            }
            if (f == -1 && count == 0) // если оно -1 и ни одного числа еще не было введено
            {
                System.out.println(0); // выводим 0
                break;   // выходим из цикла
            }
            
            i += f;    // суммируем в i введенное число
            count++;   // увеличиваем счетчик
        }
    }
}

