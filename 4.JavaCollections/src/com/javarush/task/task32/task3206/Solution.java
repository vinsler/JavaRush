package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;

/* 
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }

    // Класс T наследуемый от Item, возвращаемый тип
    public <T extends Item> T getProxy(Class<T> returnType, Class...slaveInterfaces) {
        // создаем обработчик
        ItemInvocationHandler iih = new ItemInvocationHandler();
        // загружаем класс
        ClassLoader cl = returnType.getClassLoader();
        // массив неизвестных типов интерфейсов
        Class <?> [] interfaces = new Class[slaveInterfaces.length + 1];
        interfaces[0] = returnType; // в первый ложим возвращаемый
        // копируем
        System.arraycopy(slaveInterfaces, 0 , interfaces, 1, slaveInterfaces.length);
        return (T) Proxy.newProxyInstance(cl, interfaces, iih);
    }

}