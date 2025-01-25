package com.lb.a05;

import java.util.UUID;

public class IdGenerator {
    private static IdGenerator instance; // 单例模式

    // 私有构造函数，确保不能在外部实例化
    private IdGenerator() {}

    // 获取单例对象
    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    // 生成唯一的ID（使用UUID）
    public String generate() {
        return UUID.randomUUID().toString(); // 生成一个随机的UUID作为ID
    }
}
