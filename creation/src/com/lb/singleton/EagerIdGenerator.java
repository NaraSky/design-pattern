package com.lb.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式单例模式实现
 * 特点：在类加载时就创建实例，线程安全，但不支持延迟加载。
 */
public class EagerIdGenerator {
    // 使用 AtomicLong 生成线程安全的唯一 ID
    private AtomicLong id = new AtomicLong(0);

    // 静态常量 INSTANCE，在类加载时初始化单例实例
    // 饿汉式的核心：实例在类加载时就已经创建
    private static final EagerIdGenerator INSTANCE = new EagerIdGenerator();

    /**
     * 私有构造函数，防止外部通过 new 关键字创建实例
     * 这是单例模式的关键，确保实例化过程由类自身控制
     */
    private EagerIdGenerator() {
        // 初始化操作（如果有）
    }

    /**
     * 获取单例实例的静态方法
     * 这是全局访问单例实例的唯一入口
     *
     * @return EagerIdGenerator 的单例实例
     */
    public static EagerIdGenerator getInstance() {
        return INSTANCE;
    }

    /**
     * 生成并返回一个唯一的 ID
     * 使用 AtomicLong 的 incrementAndGet() 方法保证线程安全
     *
     * @return 唯一的 ID
     */
    public long getId() {
        return id.incrementAndGet();
    }
}