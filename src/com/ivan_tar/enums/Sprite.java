package com.ivan_tar.enums;

public enum Sprite {
    HERBIVORE("[●]", AnsiColor.BLUE),
    PREDATOR("[▲]", AnsiColor.RED),
    GRASS("[g]", AnsiColor.GREEN),
    TREE("[t]", AnsiColor.BROWN),
    STONE("[s]", AnsiColor.GRAY),
    EMPTY("[ ]", AnsiColor.BLACK_BACKGROUND);

    private final String sprite;
    private final AnsiColor color;

    Sprite(String sprite, AnsiColor color) {
        this.sprite = sprite;
        this.color = color;
    }

    public String getColoredSprite() {
        return AnsiColor.BLACK_BACKGROUND.getCode() + color.getCode() + sprite + AnsiColor.RESET.getCode();
    }

    public String getSprite() {
        return sprite;
    }
}

