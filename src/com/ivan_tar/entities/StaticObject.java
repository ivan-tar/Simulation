package com.ivan_tar.entities;
import com.ivan_tar.Coordinates;

public class StaticObject extends Entity {
    private Nature nature;  // Тип объекта

    public StaticObject(Coordinates coordinates, Nature nature) {
        super(coordinates);
        this.nature = nature;
    }

    public Nature getNature() {
        return nature;
    }
}
