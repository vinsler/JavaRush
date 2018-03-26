package com.javarush.task.task17.task1709;

/* 
Предложения
*/

// 4. Программа не должна содержать synchronized методов или synchronized блоков.

public class Solution
{
    public static volatile int proposal = 0;
    // 3. Класс Solution должен содержать публичную статическую переменную int proposal.

    public static void main(String[] args)
    {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    public static class MakeProposal extends Thread
            // 1. Класс Solution должен содержать нить MakeProposal.
    {
        @Override
        public void run()
        {
            int thisProposal = proposal;

            while (proposal < 10)
            {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread
    // 2. Класс Solution должен содержать нить AcceptProposal.
    {
        @Override
        public void run()
        {
            int thisProposal = proposal;

            while (thisProposal < 10)
            {
                if (thisProposal != proposal)
                {
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }

            }
        }
    }
}
