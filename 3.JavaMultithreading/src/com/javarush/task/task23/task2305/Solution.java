package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {

    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

       /* Solution [] solutions = new Solution[2];
        solutions[0].innerClasses[0] = solutions[0].new InnerClass();
        solutions[0].innerClasses[1] = solutions[0].new InnerClass();
        solutions[1].innerClasses[0] = solutions[0].new InnerClass();
        solutions[1].innerClasses[1] = solutions[0].new InnerClass();*/

        Solution solution1 = new Solution();
        solution1.innerClasses[0] = solution1.new InnerClass();
        solution1.innerClasses[1] = solution1.new InnerClass();
        Solution solution2 = new Solution();
        solution2.innerClasses[0] = solution2.new InnerClass();
        solution2.innerClasses[1] = solution2.new InnerClass();
        Solution[] solutions = new Solution[]{solution1,solution2};
        return solutions;
    }

    public static void main(String[] args) {

    }
}
