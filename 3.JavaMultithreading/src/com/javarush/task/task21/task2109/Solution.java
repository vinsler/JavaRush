package com.javarush.task.task21.task2109;

/*
Запретить клонирование
*/

import java.util.Objects;

public class Solution {
    // 1. Класс A должен поддерживать интерфейс Cloneable.
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return i == a.i &&
                    j == a.j;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, j);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    // 2. Класс B должен быть потомком класса A.
    // 3. При объявлении класса B не должно быть явно указано implements Cloneable.
    // 4. Метод clone в классе B должен быть переопределен таким образом,
    // чтобы при попытке клонирования объекта класса B возникало исключение CloneNotSupportedException.
    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); // выкидываем ошибку при попытке клонировать
        }

    }

    // 5. Класс C должен быть потомком класса B.
    // 6. Клонирование объектов класса C должно завершаться успешно.
    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() {
            return new C(getI(), getJ(), getName()); // создаем обьект С в новой памяти и заливаем в него поля.
        }
    }

    public static void main(String[] args) {

    }
}
