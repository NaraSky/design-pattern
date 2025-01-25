package com.lb.a05;

public class InsufficientAmountException extends RuntimeException {
    // 构造方法，可以传递错误信息
    public InsufficientAmountException(String message) {
        super(message);
    }
}
