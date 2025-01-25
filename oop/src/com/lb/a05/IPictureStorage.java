package com.lb.a05;

import java.awt.*;

/**
 * 抽象（Abstraction）是面向对象编程中的一个重要概念，它允许开发者只关注事物的重要特性，而隐藏其他不相关的细节。在 Java 中，抽象可以通过 抽象类 或 接口 来实现。
 *
 * 抽象的核心思想：
 * 1. 隐藏细节：抽象通过将复杂的实现细节隐藏在类或接口的内部，允许使用者专注于类/接口的公开方法和功能，而不需要知道具体的实现方式。
 *
 * 2. 提供通用接口：在面向对象编程中，抽象类或接口定义了对象的行为规范，但不关心具体的实现。
 * 例如，IPictureStorage 接口定义了存储、获取、删除和修改图片的方法，但具体的存储方法（例如数据库、文件系统等）由 PictureStorage 类来实现。
 *
 * 3. 提高可扩展性和灵活性：通过抽象，程序的设计变得更加灵活，便于扩展和维护。
 * 如果我们想替换存储方式，只需实现一个新的 IPictureStorage 实现类（例如，CloudPictureStorage）而不需要改变使用者的代码。
 */
public interface IPictureStorage {
    // 保存图片
    void savePicture(Picture picture);

    // 根据图片ID获取图片
    Image getPicture(String pictureId);

    // 删除图片
    void deletePicture(String pictureId);

    // 修改图片的元信息
    void modifyMetaInfo(String pictureId, PictureMetaInfo metaInfo);
}

