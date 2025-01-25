package com.lb.a05;

public class DynamicArray {
    private static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected int capacity = DEFAULT_CAPACITY;
    protected Integer[] elements = new Integer[DEFAULT_CAPACITY];

    // 返回数组的大小
    public int size() {
        return this.size;
    }

    // 获取指定索引的元素
    public Integer get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // 添加元素到数组
    public void add(Integer e) {
        ensureCapacity(); // 扩容
        elements[size++] = e; // 添加新元素
    }

    // 确保数组有足够的容量
    protected void ensureCapacity() {
        if (size >= capacity) {
            // 数组满了，扩容为原来的两倍
            capacity *= 2;
            Integer[] newElements = new Integer[capacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements; // 将引用指向新的数组
        }
    }
}