package com.lb.a05;

public class InvalidAmountException extends RuntimeException {
    // 构造方法，可以传递错误信息
    public InvalidAmountException(String message) {
        super(message);
    }
}
