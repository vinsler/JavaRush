package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        StringBuilder result = new StringBuilder().append(number);
        result.append(" =");
        String [] formats = {""," + %d"," - %d"};
        StringBuilder sb = new StringBuilder();

        for (int i = number, tri = 1;
             0 < i;
             i = ++i / 3, tri = tri * 3) {
            sb.append(String.format(formats[i%3], tri));
            result.append(sb);
            sb.setLength(0);
        }
        System.out.println(result);
    }
}