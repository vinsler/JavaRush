package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
            -c name1 sex1 bd1 name2 sex2 bd2 ...
            -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
            -d id1 id2 id3 id4 ...
            -i id1 id2 id3 id4 ...
*/

public class Solution

{
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    // 1. Класс Solution должен содержать public static volatile поле allPeople типа List.

    static
    //2. Класс Solution должен содержать статический блок,
    // в котором добавляются два человека в список allPeople.
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    /**
     * CreateC(String st1, String st2, String st3)
     * создает и добавляет в конец списка новый объект
     * а так же выводит на экран индекс
     * @param st1 задает аргумент args[i] name
     * @param st2 задает аргумент args[i + 1] sex
     * @param st3 задает аргумент args[i + 2] birthday
     * @throws ParseException
     */

    public static void CreateC(String st1, String st2, String st3) throws ParseException
    {
        SimpleDateFormat sd3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        // приводим sd3 в требуемый формат даты
        switch (st2) {
            case "м": {
                allPeople.add(Person.createMale(st1, sd3.parse(st3)));
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "ж": {
                allPeople.add(Person.createFemale(st1, sd3.parse(st3)));
                System.out.println(allPeople.size() - 1);
                break;
            }
        }
    }

    /**
     * UpdateU(int i, String st1, String st2, String st3)
     * @param i обновляет в списке данные под введенным id
     * @param st1 задает аргумент args[i] name
     * @param st2 задает аргумент args[i + 1] sex
     * @param st3 задает аргумент args[i + 2] birthday
     * @throws ParseException
     */

    public static void UpdateU(int i, String st1, String st2, String st3) throws ParseException
    {
        SimpleDateFormat sd3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        // приводим sd3 в требуемый формат даты
        allPeople.get(i).setName(st1);
        allPeople.get(i).setBirthDay(sd3.parse(st3));
        switch (st2) {
            case "м":{
                allPeople.get(i).setSex(Sex.MALE);
                break;
            }
            case "ж":{
                allPeople.get(i).setSex(Sex.FEMALE);
                break;
            }
        }
    }

    /**
     * Метод DeleteD(int i)
     * @param i удаляет логически текущий элемент из списка
     */

    public static void DeleteD(int i)
    {
        allPeople.get(i).setSex(null);
        allPeople.get(i).setName(null);
        allPeople.get(i).setBirthDay(null);
    }

    /**
     * Метод InformI(int i)
     * @param i выводит все данные в консоль в формате "Миронов м 15-Apr-1990"
     */

    public static void InformI(int i)
    // Миронов м 15-Apr-1990
    // Миронова ж 25-Apr-1997
    {
        SimpleDateFormat sd3 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (allPeople.get(i).getSex()) {
            case MALE: {
                System.out.println(allPeople.get(i).getName()
                        + " " + "м" + " " +
                        sd3.format(allPeople.get(i).getBirthDay())
                );
                break;
            }
            case FEMALE:{
                System.out.println(allPeople.get(i).getName()
                        + " " + "ж" + " " +
                        sd3.format(allPeople.get(i).getBirthDay())
                );
                break;
            }
        }
    }


    public static void main(String[] args) throws ParseException
    {
        switch (args[0])
                // 7. Метод main класса Solution должен содержать оператор switch по значению args[0].
        {
            case "-c":{
                //8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
                // 3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец
                // списка allPeople, и выводить id каждого (index) на экран.
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i+=3) // args.length кол-во аргументов
                    {
                        CreateC(args[i], args[i + 1], args[i + 2]);
                        // засылаем в наш метод аргументы с текущего + 2 последующих
                        // и увеличиваем счетчик на их общее кол-во был 1, станет 4.
                    }
                }
                break;
            }

            case "-u":{
                // 4. При параметре -u программа должна обновлять данные людей
                // с заданными id в списке allPeople.
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i+=4) // args.length кол-во аргументов
                    {
                        UpdateU(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                        // засылаем в наш метод аргументы с текущего + 3 последующих
                        // и увеличиваем счетчик на их общее кол-во был 1, станет 5.
                    }
                }
                break;
            }

            case "-d":{
                // 5. При параметре -d программа должна логически удалять людей
                // с заданными id в списке allPeople.
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i++) // args.length кол-во аргументов
                    {
                        DeleteD(Integer.parseInt(args[i]));
                    }
                }
                break;
            }

            case  "-i":{
                // 6. При параметре -i программа должна выводить на экран
                // данные о всех людях с заданными id по формату указанному в задании.
                synchronized (allPeople)
                {
                    for (int i = 1; i < args.length; i++) // args.length кол-во аргументов
                    {
                        //System.out.println(i);
                        InformI(Integer.parseInt(args[i]));
                    }
                }
                break;
            }
        }
    }
}
