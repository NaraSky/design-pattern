package com.lb.a08;

public enum Level {
    INFO(1), WARN(2), ERROR(3);

    private int value;

    Level(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static Level fromInt(int i) {
        switch (i) {
            case 1: return INFO;
            case 2: return WARN;
            case 3: return ERROR;
            default: return INFO;
        }
    }
}
