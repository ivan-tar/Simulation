package com.ivan_tar.entities;

import com.ivan_tar.Coordinates;

// Травоядное
public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int health) {
        super(coordinates, speed, health);

    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }


    public int getSpeed() {
        return super.getSpeed();
    }


    @Override
    void makeMove() {

    }
}
