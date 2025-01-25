package com.lb.a05;

import java.awt.*;

// 假设这是一个图片对象
public class Picture {
    private String id;
    private Image image; // 图片本体
    private PictureMetaInfo metaInfo; // 图片元数据

    public Picture(String id, Image image) {
        this.id = id;
        this.image = image;
        this.metaInfo = new PictureMetaInfo(); // 初始化默认元数据
    }

    public String getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public void setMetaInfo(PictureMetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

    public PictureMetaInfo getMetaInfo() {
        return metaInfo;
    }
}