package com.ivan_tar.enums;

public enum AnsiColor {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    GRAY("\u001b[38;5;245m"),
    BROWN("\u001b[38;5;94m"),
    BLACK_BACKGROUND("\u001B[40m");

    private final String code;

    AnsiColor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
