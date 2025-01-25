package com.lb.a05;

// 假设这是图片数据的类
public class Image {
    private byte[] data; // 假设图片数据是字节数组

    public Image(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}