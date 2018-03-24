package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    
    String name = null;
    String address = null;
    String color = null;
    int age = 5;
    int weight = 5;
    
    public void initialize (String name)
    {
        this.name = name;
            this.weight = weight;
            this.color = color;
            this.age = age;
    }
    
    public void initialize (String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
            this.color = color;
    }
    
    public void initialize (String name, int age)
    {
        this.name = name;
        this.age = age;
            this.weight = weight;
            this.weight = weight;
            this.color = color;
    }
    
    public void initialize (int weight, String color)
    {
        this.weight = weight;
        this.color = color;
        this.name = null;
        this.address = null;
        this.age = age;
    }
    
    public void initialize (int weight, String color, String address)
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = age;
        
    }


    public static void main(String[] args) {

    }
}
