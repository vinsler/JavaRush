package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);

    static
    {
        Thread1 t1 = new Thread1();
        Solution.threads.add(t1);

        Thread2 t2 = new Thread2();
        Solution.threads.add(t2);

        Thread3 t3 = new Thread3();
        Solution.threads.add(t3);

        Thread4 t4 = new Thread4();
        Solution.threads.add(t4);

        Thread5 t5 = new Thread5();
        Solution.threads.add(t5);
    }


    public static class Thread1 extends Thread
    {
        public void run()
        {
            while (true)
            {
                System.out.print("");
            }
        }
    }

    public static class Thread2 extends Thread
    {
        public void run()
        {
            if (this.isInterrupted())
                {
                    System.out.println("InterruptedException");
                }
        }
    }

    public static class Thread3 extends Thread
    {
        public void run()
        {
            while(true)
            {
                try
                {
                    System.out.println("Ура");
                    this.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message
    {
        public void run()
        {
            while (!isInterrupted());
        }

        public void showWarning() throws InterruptedException
        {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread
    {
        public void run()
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int i = 0;
            String str= "";
            try
            {
                str = reader.readLine();
                while (!str.equals("N"))
                {
                    i += Integer.parseInt(str);
                    str = reader.readLine();
                }

                System.out.println(i);
                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }

        }
    }


    public static void main(String[] args)
    {
        /*
        Thread1 t1 = new Thread1();
        t1.start();

        Thread2 t2 = new Thread2();
        t2.start();

        Thread3 t3 = new Thread3();
        t3.start();

        Thread4 t4 = new Thread4();
        t4.start();

        Thread5 t5 = new Thread5();
        t5.start();
        */
    }
}