package com.lb.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式单例模式实现
 * 特点：在第一次调用 getInstance() 时才创建实例，支持延迟加载，但需要额外的同步机制保证线程安全。
 */
public class LazyIdGenerator {
    // 使用 AtomicLong 生成线程安全的唯一 ID
    private AtomicLong id = new AtomicLong(0);

    // 静态变量 instance，用于保存单例实例
    // 懒汉式的核心：实例在第一次调用 getInstance() 时才创建
    private static LazyIdGenerator instance;

    /**
     * 私有构造函数，防止外部通过 new 关键字创建实例
     * 这是单例模式的关键，确保实例化过程由类自身控制
     */
    private LazyIdGenerator() {
        // 初始化操作（如果有）
    }

    /**
     * 获取单例实例的静态方法
     * 使用 synchronized 关键字保证线程安全
     * 这是全局访问单例实例的唯一入口
     *
     * @return LazyIdGenerator 的单例实例
     */
    public static synchronized LazyIdGenerator getInstance() {
        // 如果实例尚未创建，则创建一个新实例
        if (instance == null) {
            instance = new LazyIdGenerator();
        }
        return instance;
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