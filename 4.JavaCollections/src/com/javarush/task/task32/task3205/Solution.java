package com.javarush.task.task32.task3205;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        // создаем обьект класс интерфейса с 3 методами
        SomeInterfaceWithMethodsImpl siwmi = new SomeInterfaceWithMethodsImpl();
        // вытаскиваем из него загружаемый класс и ложим в обьект ClassLoader
        ClassLoader classLoader = siwmi.getClass().getClassLoader();
        // вытаскиваем из него интерфейсы и кладем их в массив обьектов Class
        Class <?> [] interfaces = siwmi.getClass().getInterfaces();
        // создаем обьект нашего класса и передаем в него обьект интерфейса
        CustomInvocationHandler cih = new CustomInvocationHandler(siwmi);
        // возвращаем прокси, приведенный к интерфейсу через созданные обьекты
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, cih);
    }
}