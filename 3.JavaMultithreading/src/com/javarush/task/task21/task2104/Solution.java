package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) { // принимаем 2 строки
        this.first = first;
        this.last = last;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (o instanceof Solution);

        Solution solution = (Solution) o;

        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }


    // return n.first.equals(first) && n.last.equals(last);
   /* @Override
    public int hashCode() {
        return (first != null && last != null) ? first.hashCode() + last.hashCode() : 0;
    }*/

    public static void main(String[] args) {

        Set<Solution> s = new HashSet<>(); // создаем множество Solutuion
        s.add(new Solution("Donald", "Duck")); // кладем туда "Donald", "Duck"
        System.out.println(s.contains(new Solution("Donald", "Duck"))); // есть ли там "Donald", "Duck" ?


    }
}
