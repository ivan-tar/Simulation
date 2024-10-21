package com.ivan_tar.entities;
import com.ivan_tar.Coordinates;
import com.ivan_tar.enums.Nature;

public class StaticObject extends Entity {
    private final Nature nature;  // Тип объекта

    public StaticObject(Coordinates coordinates, Nature nature) {
        super(coordinates);
        this.nature = nature;
    }

    public Nature getNature() {
        return nature;
    }
}
