package com.javarush.task.task17.task1719;

import java.util.HashMap;
import java.util.Map;

/* 
ApplicationContext
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    // 1. Класс ApplicationContext должен быть абстрактным.

    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    // 2. Класс ApplicationContext должен содержать private поле container типа Map.
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public synchronized GenericsBean getByName(String name) {
        // 3. В getByName(String name), если необходимо, используй synchronized.
          return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        // 4. В removeByName(String name), если необходимо, используй synchronized.
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}
