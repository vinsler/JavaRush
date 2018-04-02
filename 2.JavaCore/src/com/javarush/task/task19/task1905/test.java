package com.javarush.task.task19.task1905;

public class test {

    //example Ivanov, Ivan
    public static void getContactFirstName() {
        String contact = "Ivanov, Ivan";

        String name = contact.substring(
                contact.indexOf(",") + 2,
                contact.length());

        //String name = contact.substring(0, contact.indexOf(","));

        System.out.println(name);
    }

    public static void main(String[] args) {
        getContactFirstName();
    }
}
