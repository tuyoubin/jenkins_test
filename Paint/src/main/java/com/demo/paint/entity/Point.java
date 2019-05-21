package com.demo.paint.entity;

public class Point {
    //横坐标
    private int x;
    //纵坐标
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
