package com.ivan_tar.enums;

public enum GameVariables {
    MAX_X(35),
    MAX_Y(20),
    NUMBER_OF_ENEMIES(20),
    SPEED(3),
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
