package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {

        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу


        try {
            File tfile = File.createTempFile("C:/tmp/tmp", null);
            OutputStream outputStream = new FileOutputStream(tfile);
            InputStream inputStream = new FileInputStream(tfile);

            JavaRush javaRush = new JavaRush();

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date uDate = sdf.parse("01.01.2000");

     //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User tuser = new User();
            tuser.setFirstName("ivan");
            tuser.setLastName("ivanov");
            tuser.setBirthDate(uDate);
            tuser.setMale(true);
            tuser.setCountry(User.Country.RUSSIA);

           /* User tuser0 = new User();
            tuser0.setFirstName("ioanna");
            tuser0.setLastName("ivanova");
            tuser0.setBirthDate(uDate);
            tuser0.setMale(false);
            tuser0.setCountry(User.Country.UKRAINE);*/

            javaRush.users.add(tuser);
            /*javaRush.users.add(tuser0);*/
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) {
                System.out.println("Два созданных обьекта равны, можно сдавать.");
            } else {
                System.out.println("Созданные обьекты не равны, ищи ошибку!!!");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);

            for (User u : users) {
                printWriter.println(u.getFirstName());
                printWriter.println(u.getLastName());
                printWriter.println(u.getBirthDate());
                printWriter.println(u.isMale());
                printWriter.println(u.getCountry());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            //Date date = format.parse();



            while (bufferedReader.ready()) {
                User nuser = new User();
                nuser.setFirstName(bufferedReader.readLine());
                nuser.setLastName(bufferedReader.readLine());
                nuser.setBirthDate(sdf.parse(bufferedReader.readLine()));
                nuser.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                nuser.setCountry(User.Country.valueOf(bufferedReader.readLine()));
                users.add(nuser);
            }
            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
