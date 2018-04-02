package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {


    }

    // нам нужно через RowItem обращаться к Customer & Contact
    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            for (Map.Entry pair : countries.entrySet()){
                if (pair.getValue().equals(customer.getCountryName())) {
                    return pair.getKey().toString();
                }
            }
            return null;
        }

        public String getCompany() {
            return customer.getCompanyName();
        }

        //example Ivanov, Ivan
        public String getContactFirstName() {

            /*String name = contact.getName().substring(
                    contact.getName().indexOf(",") + 2,
                    contact.getName().length());*/
            String name = contact.getName().split(", ")[1];
            return name;
        }

        public String getContactLastName() {
            /*contact.getName().substring(0, contact.getName().indexOf(","));*/
            return contact.getName().split(",")[0];
        }

        public String getDialString() {
            Pattern cifiri = Pattern.compile("\\d");
            Matcher mcifiri = cifiri.matcher(contact.getPhoneNumber());
            String st = "";

            while(mcifiri.find()) {
                st += (contact.getPhoneNumber().substring(mcifiri.start(), mcifiri.end()));
            }
            return "callto://+" + st;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}