package com.lb.a09;

public class Image {

    private String name;
    private int width;
    private int height;

    // 构造函数
    public Image(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    // Getter 和 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
