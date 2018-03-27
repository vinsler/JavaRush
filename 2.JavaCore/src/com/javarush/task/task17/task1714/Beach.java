package com.javarush.task.task17.task1714;

/* 
Comparable
*/

//2. Класс Beach должен реализовывать интерфейс Comparable.
public class Beach implements Comparable<Beach> {

    // 1. Класс Beach должен содержать три поля: String name, float distance, int quality.
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized  void setName(String name) {
        this.name = name;
    }

    public synchronized  float getDistance() {
        return distance;
    }

    public synchronized  void setDistance(float distance) {
        this.distance = distance;
    }

    public  synchronized int getQuality() {
        return quality;
    }

    public  synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

    // 2. Класс Beach должен реализовывать интерфейс Comparable.
    // 3. Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
    // float getDistance() int getQuality()
    // Реализовать метод compareTo так, чтобы он при сравнении двух пляжей
    // ---------- Извините, если передается 1 параметр, откуда выдрать 2 пляжа?
    // выдавал число, которое показывает что первый пляж лучше(позитивное число)
    // или второй пляж лучше (негативное число),и насколько он лучше.

    public synchronized int compareTo(Beach beach) {
        return (int)((this.getQuality() - beach.getQuality()) + (beach.getDistance() - this.getDistance()));
    }

}
