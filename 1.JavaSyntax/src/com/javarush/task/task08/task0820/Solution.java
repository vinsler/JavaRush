package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {

    // ---------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        for (int i =0; i < 4; i++)
        {
            result.add(new Cat());
        }

        return result;
    }

    //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    public static Set<Dog> createDogs() {
        HashSet<Dog> dog = new HashSet<Dog>();

        for (int i = 0; i < 3; i++)
        {
            dog.add(new Dog());
        }

        return dog;
    }

    //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet uni = new HashSet();

        uni.addAll(cats);
        uni.addAll(dogs);

        return uni;
    }

    //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {

        pets.removeAll(cats);
    }

    //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = =

    public static void printPets(Set<Object> pets) {

        for (Object ob : pets)
        {
            System.out.println(ob.toString());
        }
    }

    // ---------------------------------------------------------------------------------------------------------

    public static class Cat
    {

    }

    // ---------------------------------------------------------------------------------------------------------

    static public class Dog
    {

    }

    // ---------------------------------------------------------------------------------------------------------
}
