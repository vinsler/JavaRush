package com.javarush.task.task15.task1505;

import java.util.ArrayList;
import java.util.List;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution
{
    //=============================================================================================
    public static interface Alive // интерфейс Alive содержит 1 поле String containsBones
    {
        Object containsBones();
    }
    //=============================================================================================
    public static class BodyPart implements Alive // наследуется от Alive
    {
        private String name;

        public BodyPart(String name)
        {
            this.name = name;
        }

        public Object containsBones()
        {
            return "Yes";
        }

        public String toString()
        {
            return containsBones().equals("Yes") ? name + " содержит кости" : name + " не содержит кости";
        }
    }
    //=============================================================================================
    public static class Finger extends BodyPart
    {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial)
        {
            super(name);
            this.isArtificial = isArtificial;
        }

        public Object containsBones()
        {
            if (super.containsBones().equals("Yes") && !isArtificial)
            {
                return ("Yes");
            }
            else
            {
                return "No";
            }
                //return super.containsBones() && !isArtificial; //super.containsBones() && !isArtificial
        }
    }

    //############################################################################################
    public static void main(String[] args)
    {
        printlnFingers(); // вывод на экран списка fingers
        printlnBodyParts(); // вывод на экран списка BodyParts
        printlnAlives(); // вывод на экран BodyPart("Рука").containsBones()
    }
    //############################################################################################

    private static void printlnAlives()
    {
        System.out.println(new BodyPart("Рука").containsBones());
    }
    //============================================================================================
    private static void printlnBodyParts()
    {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5); // создаем список 5 элементов типа BodyPart
        bodyParts.add(new BodyPart("Рука"));        // создаем новый обьект Рука добавляем в список
        bodyParts.add(new BodyPart("Нога"));        // создаем нновый обьект Нога добавляем в список
        bodyParts.add(new BodyPart("Голова"));      // создаем новый обьект Голова добавляем в список
        bodyParts.add(new BodyPart("Тело"));        // создаем новый обьект Тело добавляем в список
        System.out.println(bodyParts.toString());        // выводим на экран список bodyParts обьектов BodyPart
    }
    //=============================================================================================
    private static void printlnFingers()
    {
        List<Finger> fingers = new ArrayList<Finger>(5); // создаем список 5 элементов типа Finger
        fingers.add(new Finger("Большой", true)); // создаем новый обьект Большой, Да
        fingers.add(new Finger("Указательный", true)); // создаем новый обьект Указательный, Да
        fingers.add(new Finger("Средний", true)); // создаем новый обьект Средний, Да
        fingers.add(new Finger("Безымянный", false)); // создаем новый обьект Безымянный, Нет
        fingers.add(new Finger("Мизинец", true)); // создаем новый обьект Мизинец, Да
        System.out.println(fingers.toString()); // выводим на экран список fingers обьектов Finger
    }
    //=============================================================================================
}

