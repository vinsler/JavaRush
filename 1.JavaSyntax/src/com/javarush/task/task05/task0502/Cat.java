package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        if (this.strength > anotherCat.strength) return true;
        else return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        
        cat1.name = "murzik";
        cat1.age = 10;
        cat1.weight = 10;
        cat1.strength = 8;
        
        cat2.name = "markiz";
        cat2.age = 5;
        cat2.weight = 8;
        cat2.strength = 12;
        
        // cat1.fight(cat2);

    }
}
