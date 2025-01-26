package com.lb.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举方式实现的单例模式
 * 特点：天然线程安全，防止反射攻击和序列化破坏单例，代码简洁。
 */
public enum EnumIdGenerator {
    // 枚举实例，天然单例
    INSTANCE;

    // 使用 AtomicLong 生成线程安全的唯一 ID
    // AtomicLong 是一个原子变量类型，支持线程安全的原子操作，如 incrementAndGet()
    private AtomicLong id = new AtomicLong(0);

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