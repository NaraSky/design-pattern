package com.lb.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类方式实现的单例模式
 * 特点：支持延迟加载，且在多线程环境下保证线程安全，无需额外的同步机制。
 */
public class StaticInnerClassIdGenerator {
    // 使用 AtomicLong 生成线程安全的唯一 ID
    // AtomicLong 是一个原子变量类型，支持线程安全的原子操作，如 incrementAndGet()
    private AtomicLong id = new AtomicLong(0);

    /**
     * 私有构造函数，防止外部通过 new 关键字创建实例
     * 这是单例模式的关键，确保实例化过程由类自身控制
     */
    private StaticInnerClassIdGenerator() {
        // 初始化操作（如果有）
    }

    /**
     * 静态内部类，用于持有单例实例
     * 静态内部类的特性：只有在被调用时才会加载，从而实现延迟加载
     */
    private static class SingletonHolder {
        // 静态常量 instance，在类加载时初始化单例实例
        private static final StaticInnerClassIdGenerator instance = new StaticInnerClassIdGenerator();
    }

    /**
     * 获取单例实例的静态方法
     * 这是全局访问单例实例的唯一入口
     *
     * @return StaticInnerClassIdGenerator 的单例实例
     */
    public static StaticInnerClassIdGenerator getInstance() {
        return SingletonHolder.instance;
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