package com.lb.a05;

public class SortedDynamicArray extends DynamicArray {
    @Override
    public void add(Integer e) {
        ensureCapacity(); // 确保容量

        int i;
        // 找到合适的位置插入新元素，保持数组有序
        for (i = size - 1; i >= 0; --i) {
            if (elements[i] > e) {
                elements[i + 1] = elements[i]; // 移动元素
            } else {
                break; // 找到合适位置
            }
        }
        elements[i + 1] = e; // 插入新元素
        ++size; // 增加大小
    }
}