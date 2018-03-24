package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name = null, address = null, color = "kakdela";
    int age = 5, weight = 5;
    
    public Cat(String name)
    {
        this.name = name;
        
        this.color = color;
        this.age = age;
        this.weight = weight;
    }
    
    public Cat(String name, int weight, int age)
    {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight; 
    }
    
    public Cat(String name, int age)
    {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight; 
    }
    
    public Cat(int weight, String color)
    {
        this.color = color;
        this.age = age;
        this.weight = weight; 
    }
    
    public Cat(int weight, String color, String address)
    {
        this.color = color;
        this.age = age;
        this.weight = weight; 
        this.address = address;
    }






    public static void main(String[] args) {

    }
}
