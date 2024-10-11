package com.ivan_tar;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.setupDefaultEntityPositions();

        FieldConsoleRenderer renderer = new FieldConsoleRenderer();
        renderer.render(field);
        int a = 123;
        int b = 123;
    }
}