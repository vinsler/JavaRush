package com.javarush.task.task06.task0621;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat catDed = new Cat(reader.readLine());
        Cat catBab = new Cat(reader.readLine());
        Cat catFather = new Cat(reader.readLine(), catDed, null);
        Cat catMother = new Cat(reader.readLine(), null, catBab);
        Cat catSone = new Cat(reader.readLine(), catFather, catMother);
        Cat catDota = new Cat(reader.readLine(), catFather, catMother);

        System.out.println(catDed);
        System.out.println(catBab);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSone);
        System.out.println(catDota);
    }

    public static class Cat {
        private String name;
        private Cat father, mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            if (father == null & mother == null)
                return "Cat name is "+name+", no mother, no father ";
            if (father == null & mother != null)
                return "Cat name is "+name+", mother is "+mother.name+", no father ";
            else if (mother == null & father != null)
                return "Cat name is "+name+", no mother, father is "+father.name;
            else
                return "Cat name is "+name+", mother is "+mother.name+", father is "+father.name;
        }
    }

}