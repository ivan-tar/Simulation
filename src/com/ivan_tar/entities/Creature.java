package com.ivan_tar.entities;

import com.ivan_tar.Coordinates;

// Существо
abstract public class Creature extends Entity {
    int speed;
    int health;


    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }


    public int getSpeed() {
        return speed;
    }
    public int getHealth() {
        return health;
    }



    // для каждого существа своя реализация
    abstract void makeMove();


}
