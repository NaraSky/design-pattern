package com.lb.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检查锁定（Double-Checked Locking）单例模式实现
 * 特点：支持延迟加载，且在多线程环境下保证线程安全，同时减少同步开销。
 */
public class DoubleCheckedIdGenerator {
    // 使用 AtomicLong 生成线程安全的唯一 ID
    // AtomicLong 是一个原子变量类型，支持线程安全的原子操作，如 incrementAndGet()
    private AtomicLong id = new AtomicLong(0);

    // 静态变量 instance，用于保存单例实例
    private static DoubleCheckedIdGenerator instance;

    /**
     * 私有构造函数，防止外部通过 new 关键字创建实例
     * 这是单例模式的关键，确保实例化过程由类自身控制
     */
    private DoubleCheckedIdGenerator() {
        // 初始化操作（如果有）
    }

    /**
     * 获取单例实例的静态方法
     * 使用双重检查锁定（Double-Checked Locking）保证线程安全
     * 这是全局访问单例实例的唯一入口
     *
     * @return DoubleCheckedIdGenerator 的单例实例
     */
    public static DoubleCheckedIdGenerator getInstance() {
        // 第一次检查：如果实例已经存在，直接返回，避免不必要的同步
        if (instance == null) {
            // 同步块，保证只有一个线程可以进入
            synchronized (DoubleCheckedIdGenerator.class) {
                // 第二次检查：防止多个线程同时通过第一次检查后重复创建实例
                if (instance == null) {
                    instance = new DoubleCheckedIdGenerator();
                }
            }
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