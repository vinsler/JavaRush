package com.javarush.task.task17.task1716;

/* 
Синхронизированные методы
*/

public class Solution {

    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() { // использует возврат из method3
        Double d = method3();
    }

    protected void method1(String param1) { // создает и запускает новый method0
        Solution solution = new Solution();
        solution.method0();
    }

    public void method2(int param1) { // увеличивает что падают на вход на 1
        param1++;
    }

    synchronized double method3() { // возвращает рандом + param
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    private synchronized void method4() { // добавляет в строку sb "1111"
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {
        // создает новый стринбуфер и добавляет туда 3 раза входящую строку
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) { // sb, method7
        // выводит строку, потом метод7, потом добавляет в sb новый билдер и вовзращает sb
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) { //
        return "" + param2;
    }

    public static void main(String[] args) {

    }

}
