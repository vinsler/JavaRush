package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top = 0, left = 0, width = 0, height = 0;
    
    public void initialize (int left, int width, int height)
    {
        this.top = top;
        
        this.left = left;
        this.width = width;
        this.height = height;
    }
    
    public void initialize (int top, int left)
    {
        this.top = top;
        this.left = left;
        
        this.width = width;
        this.height = height;
    }

    public void initialize (int top, int left, int width, int height)
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    
    public void initialize (Rectangle rectangle)
    {
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }


    public static void main(String[] args) {

    }
}
