package com.lb.ddd;

public enum Status {
    TO_BE_EXECUTED, // 待执行
    EXECUTED,       // 已执行
    FAILED,         // 执行失败
    CLOSED          // 交易关闭
}
