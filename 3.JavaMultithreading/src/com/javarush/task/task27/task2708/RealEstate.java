package com.javarush.task.task27.task2708;

import java.util.HashSet;
import java.util.Set;

public class RealEstate {

    private final Set<Apartment> allApartments;
    private final Set<Apartment> activeApartments;
    private Object lock = new Object();

    public RealEstate() {
        allApartments = new HashSet();
        activeApartments = new HashSet();

        //add some data
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
    }

    public Set<Apartment> getAllApartments() {
        return allApartments;
    }

    public void up(Apartment apartment) {
        synchronized (lock) {
            activeApartments.add(apartment);
        }
    }

    public void revalidate() {
        synchronized (lock) {
            activeApartments.clear();
            for (Apartment apartment : allApartments) {
                boolean randomValue = Math.random() * 2 % 2 == 0;
                apartment.revalidate(randomValue);
            }
        }
    }
}
