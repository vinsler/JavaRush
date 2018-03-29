package com.javarush.task.task18.task1815;

import java.util.ArrayList;
import java.util.List;

/* 
Таблица
*/

public class Solution {
    // 1. Класс TableInterfaceWrapper должен реализовывать интерфейс ATableInterface.
    public class TableInterfaceWrapper implements ATableInterface{
        // 2. Класс TableInterfaceWrapper должен инициализировать в конструкторе поле типа ATableInterface.
        ATableInterface aTableInterface;

        public TableInterfaceWrapper(ATableInterface aTableInterface){
            this.aTableInterface = aTableInterface;
        }


        public void setModel(List rows) {
            //3. Метод setModel() должен вывести в консоль количество элементов в новом листе перед обновлением модели.
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }

        public String getHeaderText() {
            //4. Метод getHeaderText() должен возвращать текст в верхнем регистре.
            aTableInterface.getHeaderText();
            return aTableInterface.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText) {
            //5. Метод setHeaderText() должен устанавливать текст для заголовка без изменений.
            aTableInterface.setHeaderText(newHeaderText);

        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}