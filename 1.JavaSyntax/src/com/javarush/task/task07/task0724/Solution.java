package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human boim1 = new Human("Fedr",false, 53);
        Human boim2 = new Human("Petr",false, 54);
        Human boim3 = new Human("Masha",true, 52);
        Human boim4 = new Human("Glasha",true, 51);
        
        Human soim1 = new Human("dfedyaMasha", false, 22, boim1, boim3);
        Human soim2 = new Human("dMashaFedya", true, 21, boim3, boim1);
        Human soim3 = new Human("dPetyaGlasha", false, 24, boim2, boim4);
        Human soim4 = new Human("dPetyaGlasha", false, 19, boim2, boim4);
        Human soim5 = new Human("dGlashaPetya", true, 18, boim4, boim2);
        
       System.out.println(boim1.toString());
        System.out.println(boim2.toString());
        System.out.println(boim3.toString());
        System.out.println(boim4.toString());
        
        System.out.println(soim1.toString());
        System.out.println(soim2.toString());
        System.out.println(soim3.toString());
        System.out.println(soim4.toString());
        System.out.println(soim5.toString());
        
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;
        
        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        
        Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















