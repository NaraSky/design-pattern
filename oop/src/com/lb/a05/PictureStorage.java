package com.lb.a05;

import java.util.HashMap;
import java.util.Map;

// PictureStorage 实现 IPictureStorage 接口
public class PictureStorage implements IPictureStorage {
    private Map<String, Picture> pictureDatabase = new HashMap<>(); // 用于存储图片的数据库（模拟）

    @Override
    public void savePicture(Picture picture) {
        if (picture != null) {
            pictureDatabase.put(picture.getId(), picture); // 保存图片到数据库
            System.out.println("图片已保存，ID: " + picture.getId());
        } else {
            throw new IllegalArgumentException("图片不能为null");
        }
    }

    @Override
    public Image getPicture(String pictureId) {
        Picture picture = pictureDatabase.get(pictureId); // 根据图片ID获取图片
        if (picture != null) {
            System.out.println("获取图片，ID: " + pictureId);
            return picture.getImage(); // 假设 Picture 类有 getImage 方法
        } else {
            System.out.println("未找到图片，ID: " + pictureId);
            return null;
        }
    }

    @Override
    public void deletePicture(String pictureId) {
        if (pictureDatabase.remove(pictureId) != null) {
            System.out.println("图片已删除，ID: " + pictureId);
        } else {
            System.out.println("未找到图片，无法删除，ID: " + pictureId);
        }
    }

    @Override
    public void modifyMetaInfo(String pictureId, PictureMetaInfo metaInfo) {
        Picture picture = pictureDatabase.get(pictureId);
        if (picture != null) {
            picture.setMetaInfo(metaInfo); // 假设 Picture 类有 setMetaInfo 方法
            System.out.println("图片元信息已更新，ID: " + pictureId);
        } else {
            System.out.println("未找到图片，无法更新元信息，ID: " + pictureId);
        }
    }
}