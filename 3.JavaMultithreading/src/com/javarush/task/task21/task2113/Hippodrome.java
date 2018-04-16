package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List <Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void  move() {
        for (Horse cxHourse: this.horses) {
            cxHourse.move();
        }
    }

    public void print() {
        for (Horse cxHourse: this.horses) {
            cxHourse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }

    }

    /*public Horse getWinner(){
        String stWin = "";
        double dbl = 0;

        for (int i = 0; i < this.horses.size(); i++) {
            //System.out.println(this.horses.get(i).getName() + " - " + this.horses.get(i).getDistance());
            if (this.horses.get(i).getDistance() > dbl) {
                dbl = this.horses.get(i).getDistance();
            }
        }

        for (int i = 0; i < this.horses.size(); i++) {
            if (this.horses.get(i).getDistance() == dbl) {
                return this.horses.get(i);
            }
        }
        return null;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }*/

    public Horse getWinner()
    {
        double max = Integer.MIN_VALUE;
        Horse horse1 = new Horse("1",0,0);
        for (Horse horse : horses)
        {
            if (horse.getDistance() > max) {max = horse.getDistance(); horse1 = horse;}
        }
        return horse1;
    }

    public void printWinner()
    {
        System.out.printf("Winner is %s!",getWinner().getName());
    }



    public static void main(String[] args) throws InterruptedException {
        List <Horse> horselist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String strName = "horse" + i;
            horselist.add(new Horse(strName, 3, 0));
        }
        game = new Hippodrome(horselist);
        game.run();
        game.printWinner();
    }
}
