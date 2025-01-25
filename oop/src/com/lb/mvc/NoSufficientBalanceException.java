package com.lb.mvc;

public class NoSufficientBalanceException extends RuntimeException {
    public NoSufficientBalanceException(String message) {
        super(message);
    }
}
