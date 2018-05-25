package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List <Student> students = new ArrayList();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List students) {
        this.students = students;
    }


    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student: students) {
            if (student.getAverageGrade() >= averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double ag = 0.00;
        for (Student student: students) {
            if (student.getAverageGrade() > ag) {
                ag = student.getAverageGrade();
            }
        }
        for (Student student: students) {
            if (student.getAverageGrade() == ag) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        double ag = students.get(0).getAverageGrade();
        for (Student student: students) {
            if (student.getAverageGrade() < ag) {
                ag = student.getAverageGrade();
            }
        }
        for (Student student: students) {
            if (student.getAverageGrade() == ag) {
                return student;
            }
        }
        return null;
    }

    public void expel(Student student){
        students.remove(student);
    }


}