package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if (cacheMap.containsKey(key)) {
            return softReference.get();
        }
        return null;
    }

    public AnyObject put(Long key, AnyObject value) {
        // добавляем пару независимо от того что там было или нет, т.к. это ссылка
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if (softReference != null) { // и если по ссылке там не пусто
            AnyObject any = softReference.get(); // возвращаем то что там есть
            softReference.clear(); // и очищаем ссылку
            return any;
        }
        return null; // или возвращаем пусто
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if (softReference == null) { // можно наоборот сначала пусто, а потом значение
            return null;
        }
        AnyObject any = softReference.get();
        softReference.clear();
        return any;
    }
}