package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable { // вот эту фичю, чб не матерился никто внутри

    public static class A {

        protected String nameA = "A";

        public A() {} // добавить фичу сюда, все-равно значение сохранено )))

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.defaultWriteObject();
            out.writeObject(nameA); // поскольку nameA не Serializable, его нужно запихнуть
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            in.defaultReadObject();
            nameA = (String) in.readObject(); // а тут его нужно вытащить
        }

        public B(String nameA, String nameB) {
            super(nameA); // A B2
            this.nameA += nameA; // B2
            this.nameB = nameB; // C33
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b); // тут перескок на private void writeObject(ObjectOutputStream out)

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject(); // тут перескок на private void readObject(ObjectInputStream in)

        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
