package com.ivan_tar.enums;

public enum GameVariables {
    MAX_X(40),
    MAX_Y(12),
    NUMBER_OF_ENEMIES(5), //(MAX_X.getValue() * MAX_Y.getValue())/10
    SPEED(1),
    HEALTH(65),
    ATTACK_POWER(20);

    private final int value;

    GameVariables(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
