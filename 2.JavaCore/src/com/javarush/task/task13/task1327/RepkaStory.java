package com.javarush.task.task13.task1327;

import java.util.List;

public class RepkaStory
{
    static void tell(List<Person> items)  // передаем список из мейн репка дедка бабка внучка
    {
        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i - 1);
            second = items.get(i);
            second.pull(first); // тут второй тянет за первого
        }
    }
}
