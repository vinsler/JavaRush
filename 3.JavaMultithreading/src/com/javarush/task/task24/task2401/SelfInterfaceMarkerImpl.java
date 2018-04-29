package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {

    public void soutlet(){
        System.out.println("Я первый метод...");
    }

    public void soutlet2(){
        soutlet();
        System.out.println("вывод из первого наверху и это Второй метод");
    }
}
