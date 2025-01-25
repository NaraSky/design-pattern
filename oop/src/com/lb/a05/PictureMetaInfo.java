package com.lb.a05;

// 假设这是图片元信息的类
public class PictureMetaInfo {
    private String title;
    private String description;

    public PictureMetaInfo() {
        this.title = "无标题";
        this.description = "无描述";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}