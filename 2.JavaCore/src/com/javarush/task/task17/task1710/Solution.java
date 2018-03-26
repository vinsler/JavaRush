package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();
    // 1. Класс Solution должен содержать public static поле allPeople типа List.

    static
    //2. Класс Solution должен содержать статический блок,
    // в котором добавляются два человека в список allPeople.
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //System.out.println(args[0] +" "+ args[1] + " " + args[2] + " " + args[3] + " " + args[4]);

        //if (args.length != 0)

        switch ((args[0])) // проверяем 1-ый аргумент на 4 возможных
        {
            case "-c":
                // 3. При запуске программы с параметром -с программа должна добавлять человека
                // с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
                {
                    SimpleDateFormat sd3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    // приводим sd3 в требуемый формат даты
                    switch (args[2]) // проверяем 3-ий аргумент
                    {
                        case "м": { // добавляем в список новый объект с параметрами
                            allPeople.add(Person.createMale(args[1], sd3.parse(args[3])));
                            System.out.println(allPeople.size() - 1); //lastIndexOf(Person.createMale(args[1], sd3.parse(args[3]))));
                            break;
                        }
                        case "ж": { // аналог case "m" см. чуть-чуть выше :)
                            allPeople.add(Person.createFemale(args[1], sd3.parse(args[3])));
                            System.out.println(allPeople.size() - 1);
                            break;
                        }
                    }
                    break;
                }
            case "-u":
                // 4. При запуске программы с параметром -u
                // программа должна обновлять данные человека с заданным id в списке allPeople.
                // -u id name sex bd
                {
                    SimpleDateFormat sd3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    switch (args[3]) //allPeople.get(Integer.parseInt(args[3])).getSex())
                    {
                        case "м": {
                            allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], sd3.parse(args[4])));
                            break;
                        }
                        case "ж": {
                            allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], sd3.parse(args[4])));
                            break;
                        }
                    }
                    break;
                }
            case "-d":
                // 5. При запуске программы с параметром -d
                // программа должна логически удалять человека с заданным id в списке allPeople.
                // -d id
                {
                    //System.out.println("вошли в -d, удаляем  " + Integer.parseInt(args[1]));
                    allPeople.get(Integer.parseInt(args[1])).setName(null);
                    allPeople.get(Integer.parseInt(args[1])).setSex(null);
                    allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                    break;
                }
            case "-i":
                // 6. При запуске программы с параметром -i программа должна выводить
                // на экран данные о человеке с заданным id по формату указанному в задании.
                {
                    //System.out.println("Вошли в -i");
                    SimpleDateFormat sd3 = new SimpleDateFormat("dd-MMM-yyyy");
                    //System.out.println(allPeople.get(Integer.parseInt(args[1])).getName());
                    String st = "";
                    switch (allPeople.get(Integer.parseInt(args[1])).getSex())
                    {
                        case MALE: st = "м"; break;
                        case FEMALE: st = "ж"; break;
                    }

                    System.out.println
                            (
                            allPeople.get(Integer.parseInt(args[1])).getName() +
                                    " " + st + " " +
                                    sd3.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay())
                    );
                    break;
                }
                default: {
                    System.out.println("4e za NAH?");
                    break;
                }
        }
    }
}
