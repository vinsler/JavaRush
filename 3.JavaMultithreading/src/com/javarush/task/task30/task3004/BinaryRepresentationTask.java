package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {
        int a = i % 2; // остаток
        int b = i / 2; // целое число
        String result = String.valueOf(a); // строка остатка
        //System.out.println(i + " переводим в 2 ... целое число->" + b + " , остаток -> " + a);
        if (b > 0) { // если делится и есть целое то рекурсия
            BinaryRepresentationTask brt = new BinaryRepresentationTask(b);// создаем обьект с целым числом
            brt.fork(); // запускаем его асинхронно
            return brt.join() + result; // ждем выполнения и добавляем к нему конец числа
        }
        return result;
    }
}
