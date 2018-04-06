package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {

        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        try {
            File myFile = File.createTempFile("fame", null);
            OutputStream outputStream = new FileOutputStream(myFile);
            InputStream inputStream = new FileInputStream(myFile);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            if (ivanov.equals(somePerson)) {
                System.out.println("ivanov == someperson");
            } else {
                System.out.println("ivanov != someperson");
            }

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны



        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();
        // Asset = name + price

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter writer = new PrintWriter(outputStream); // создаем поток на запись
            writer.println(name); // записываем имя

            System.out.println(name);

            for (Asset a : assets) { // записываем список assets пока не пустой имя + цена
                writer.println(a.getName());
                writer.println(Double.toString(a.getPrice())); // записываем строку

                System.out.println(a.getName() + " " + Double.toString(a.getPrice()));
            }
            writer.flush(); // записываем на диск
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); // читаем построчно
            name = reader.readLine(); // читаем имя

            System.out.println(name);

            String aName, cena;

            while (reader.ready()) { // пока есть чего читать
                aName = reader.readLine(); // читаем имя список assets
                cena = reader.readLine(); // читаем цену строку список assets
                Asset asset = new Asset(aName, Double.parseDouble(cena)); // сохраняем в строку в дабле
                assets.add(asset);

                System.out.println(asset.getName() +" " + asset.getPrice());
                //System.out.println(aName + " " + cena);
            }

        }
    }
}
