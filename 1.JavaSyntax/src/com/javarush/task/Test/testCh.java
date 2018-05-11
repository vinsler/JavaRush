package com.javarush.task.Test;

import java.util.ArrayList;

public class testCh {
        public static void main(String[] args)  {
            // трое детей
            Human childMan1 = new Human("Michael", false, 12, null);
            Human childMan2 = new Human("Dimitries", false, 13, null);
            Human childWoman1 = new Human("Anastasiya", true, 7, null);

            ArrayList<Human> child = new ArrayList<>();
            child.add(childMan1);
            child.add(childMan2);
            child.add(childWoman1);

            Human papa = new Human("Alexei", false, 41, child); // отец
            Human mama = new Human("Maria", true, 38, child); // мать

            ArrayList<Human> arrayListPapa = new ArrayList<>();
            arrayListPapa.add(mama);

            ArrayList<Human> arrayListMama = new ArrayList<>();
            arrayListMama.add(papa);

            Human ded1 = new Human("slav", false, 71, arrayListPapa);
            Human ded2 = new Human("vova", false, 87, arrayListMama);

            Human baba1 = new Human("laris", true, 75, arrayListPapa);
            Human baba2 = new Human("galya", true, 88, arrayListMama);

            System.out.println(childMan1);
            System.out.println(childMan2);
            System.out.println(childWoman1);
            System.out.println(papa);
            System.out.println(mama);
            System.out.println(ded1);
            System.out.println(ded2);
            System.out.println(baba1);
            System.out.println(baba2);
        }


        public static class Human { // 1. Создай класс Human с полями
            String name;                // имя (String)
            boolean sex;                // пол (boolean)
            int age;                    // возраст (int)
            ArrayList<Human> children;  // дети (ArrayList<Human>)
            // вот тут у меня впервые появился когнитивный диссонанс
            // как блеа можно создать чертеж переменной внутри переменной?
            // это факториал что ли? Мы только описываем новый класс и уже
            // запихиваем его внутрь самого себя, да еще и списком? вот де фак?
            // Наверно это просто самый ужасный пример, который я видел, да еще на первых лвлах

            // Класс это чертеж, ссылка на будущую память с определенными полями или просто обьект, поэтому
            // наверно можно сделать ссылку внутри ссылки на такую же ссылку сколько угодно раз,
            // но дело в том, что каждая ссылка или обьект, будет иметь в себе поле или поля, которые
            // просто НЕ ОБЯЗАТЕЛЬНО должны быть вообще в каждом обьекте, они могут быть, а могут и не быть,
            // просто тогда смысл обьекта теряется, поэтому какие-то поля все же должны быть инициализированы
            // и конкретно в этом примере, у детей нет поля ArrayList<Human> children;, в остальных случаях
            // есть все поля, а так же:
            // у бабушки и дедушки есть дети, которые мама и папа.
            // у мамы и папы, есть дети.
            // в виду этого, для детей нужна инициализация без детей, остальным с детьми.
            // инициализацию без детей, можно заменить на null.

            public Human(String name, boolean sex, int age, ArrayList <Human> children) {
                this.name = name;   // this.4To-Hu6ygb указывает на поля класса, в котором мы находимся
                this.sex = sex;     // name или sex итп это параметры в скобках внутри метода/конструктора
                this.age = age;     // присваиваем поля переданные нам в new Human("Вася", false, 10, null)
                this.children = children; // конкретно в создаваемый нами новый обьект
            }

            public String toString() {
                StringBuilder sbTmp = new StringBuilder();
                sbTmp.append("Имя: ").append(this.name).append(", пол: ");
                if (this.sex) {
                    sbTmp.append("мужской");
                } else {
                    sbTmp.append("женский");
                }
                sbTmp.append(", возраст: ").append(this.age);
                if (this.children != null) {
                    sbTmp.append(", дети: ");
                    for (Human human : this.children) {
                        sbTmp.append(human.name).append(", ");
                    }
                    sbTmp.setLength(sbTmp.length() - 2);
                    sbTmp.append(".");
                }
                return sbTmp.toString();
            }
        }
}
