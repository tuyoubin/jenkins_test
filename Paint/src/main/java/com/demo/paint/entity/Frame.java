package com.demo.paint.entity;

import java.io.Serializable;

public class Frame implements Serializable {
    private int startX;
    private int startY;
    private int width;
    private int height;
    private String label;
    private String shape;

    public Frame(int startX, int startY, int width, int height, String label, String shape){
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.label = label;
        this.shape = shape;
    }

    public int getStartX() { return startX; }
    public int getStartY() { return startY; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getLabel() {
        return label;
    }
    public String getShape() {
        return shape;
    }
}
