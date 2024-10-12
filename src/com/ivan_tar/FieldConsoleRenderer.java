package com.ivan_tar;
import com.ivan_tar.entities.*;
import com.ivan_tar.enums.*;

public class FieldConsoleRenderer {

    public void render(Field field){
        for (int y = GameVariables.MAX_Y.getValue(); y >=1; y--){
            StringBuilder line = new StringBuilder();
            for (int x = GameVariables.MAX_X.getValue(); x >= 1; x--){
                Coordinates coordinates = new Coordinates(x, y);
                if(field.isSquareEmpty(coordinates)){
                    line.append(Sprite.EMPTY.getColoredSprite());
                } else {
                    line.append(getEntitySprite(field.getEntity(coordinates)));
                }
            }
            line.append(AnsiColor.RESET.getCode());
            System.out.println(line);
        }
    }

    private String getEntitySprite(Entity entity) {
        if (entity instanceof StaticObject) {
            StaticObject staticObject = (StaticObject) entity;
            switch (staticObject.getNature()) {
                case GRASS -> {
                    return Sprite.GRASS.getColoredSprite();
                }
                case TREE -> {
                    return Sprite.TREE.getColoredSprite();
                }
                case STONE -> {
                    return Sprite.STONE.getColoredSprite();
                }
                default -> {
                    return Sprite.EMPTY.getColoredSprite();
                }
            }
        } else if (entity instanceof Herbivore) {
            return Sprite.HERBIVORE.getColoredSprite();
        } else if (entity instanceof Predator) {
            return Sprite.PREDATOR.getColoredSprite();
        } else {
            return Sprite.EMPTY.getColoredSprite();
        }
    }
}
