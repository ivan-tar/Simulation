package com.ivan_tar.entities;

import com.ivan_tar.Coordinates;

// Хищник
public class Predator extends Creature {
    int attackPower;

    public Predator(Coordinates coordinates, int speed, int health, int attackPower) {
        super(coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    void makeMove() {}
}
