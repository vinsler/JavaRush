package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Integer o)
    {
        System.out.println(m + n + o);
    }

    public static void printMatrix(int n, int m)
    {
        System.out.println(m + n);
    }

    public static void printMatrix(int n, int o, int m)
    {
        System.out.println(m + n + o);
    }

    public static void printMatrix(Integer n, int o, int m)
    {
        System.out.println(m + n + o);
    }

    public static void printMatrix(int n, int o, double m)
    {
        System.out.println(m + n + o);
    }

    public static void printMatrix(int n, int o, float m)
    {
        System.out.println(m + n + o);
    }

    public static void printMatrix(int n, int o, long m)
    {
        System.out.println(m + n + o);
    }

    public static void printMatrix(long n, int o, int m)
    {
        System.out.println(m + n + o);
    }
}
