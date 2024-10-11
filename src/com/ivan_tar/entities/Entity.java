package com.ivan_tar.entities;

import com.ivan_tar.Coordinates;

// Объект
abstract public class Entity {
    public Coordinates coordinates;

    public Entity(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }
}
