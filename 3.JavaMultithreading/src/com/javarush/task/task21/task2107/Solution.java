package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable{

    protected Map<String, User> users = new LinkedHashMap();

    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry <String, User> pair : users.entrySet()) {
            solution.users.put(pair.getKey(), pair.getValue());
        }
        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);
            System.out.println(solution != clone);

            System.out.println(solution.users);
            System.out.println(clone.users);
            System.out.println(solution.getClass() == clone.getClass());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }



    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }
}
