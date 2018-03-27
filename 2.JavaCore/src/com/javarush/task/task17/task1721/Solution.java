package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {

    public static List<String> allLines = new ArrayList<String>();
    // 1. Класс Solution должен содержать public static поле allLines типа List.

    public static List<String> forRemoveLines = new ArrayList<String>();
    //2. Класс Solution должен содержать public static поле forRemoveLines типа List.

    public static void main(String[] args) throws IOException {

        // 4. Программа должна считывать c консоли имена двух файлов.
        BufferedReader readerf = new BufferedReader(new InputStreamReader(System.in));
        String f1 = readerf.readLine();
        String f2 = readerf.readLine();
        readerf.close();

        // 5. Программа должна считывать построчно данные из первого файла в список allLines.

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f1)));
        String stmp = "";
        while ((stmp = reader.readLine()) != null) {
            allLines.add(stmp);
        }

        // 6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));
        stmp = "";
        while ((stmp = reader.readLine()) != null) {
            forRemoveLines.add(stmp);
        }
        reader.close();

        Solution sol = new Solution();
        sol.joinData();


    }

    public void joinData () throws CorruptedDataException {
        // 3. Класс Solution должен содержать public void метод joinData()
        // который может бросать исключение CorruptedDataException.

        for (String sl : forRemoveLines) {
            // проходим весь список forRemoveLines и если такая строка содержится, то удаляем
            // а если не содержится то удаляем все строки из allLines

            if (!allLines.contains(sl))
            {
                allLines.clear();
                throw new CorruptedDataException();
            }

            else {
                allLines.remove(sl);
            }
        }
    }

}
