package com.javarush.task.task17.task1712;

public class Waiter implements Runnable {
    public boolean continueWorking = true; // продолжать работать равно правда

    @Override
    public void run() {
        Manager manager = Manager.getInstance(); // переменная manager равна создает нового менеджера

        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            // пока продолжаем работать или НЕ менеджер гет это отдельный класс коллекций ппц там короче
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
                //System.out.println("djikasdfsadfasdfasdfasdfdsf");
                Dishes dishes = manager.getDishesQueue().poll();
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            } else {                                         //берем новый заказ
                Table table = manager.getNextTable();
                Order order = table.getOrder();
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                manager.getOrderQueue().add(order);
            }
            try {
                Thread.sleep(100);  //walking to the next table
            } catch (InterruptedException e) {
            }
        }
    }
}
