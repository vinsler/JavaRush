package com.javarush.task.task25.task2515;

public class Canvas {

    private int width;
    private int height;
    private char matrix[][];


    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }


    public void setPoint(double x, double y, char c) {
        int x2 = (int) Math.round(x);
        int y2 = (int) Math.round(y);

        if (x2<0 || y2<0 || y2>matrix.length || x2>matrix[0].length) {
            return;
        }
        matrix[y2][x2] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }


}
