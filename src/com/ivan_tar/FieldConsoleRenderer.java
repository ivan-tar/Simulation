package com.ivan_tar;

import com.ivan_tar.entities.Entity;
import com.ivan_tar.entities.StaticObject;

public class FieldConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GRAY = "\u001b[38;5;245m";
    public static final String ANSI_BROWN = "\u001b[38;5;94m";
    public static final String ANSI_CYAN = "\u001B[36m;1m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";


    public void render(Field field){
        for (int y = 20; y >=1; y--){
            String line = "";
            for (int x = 35; x >= 1; x--){
                Coordinates coordinates = new Coordinates(x, y);
                if(field.isSquareEmpty(coordinates)){
                    line += getSpringForEmptySquare(coordinates);
                } else {
                    line += getEntitySpite(field.getEntity(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }



    private String colorizeSprite(String sprite){
        String result = sprite;
        result = switch (sprite) {
            case " ● " -> ANSI_BLUE + result;
            case " ▲ " -> ANSI_RED + result;
            case " g " -> ANSI_GREEN + result;
            case " t " -> ANSI_BROWN + result;
            case " s " -> ANSI_GRAY + result;
            default -> result;
        };

        return ANSI_BLACK_BACKGROUND + result;
    }
    private String getSpringForEmptySquare(Coordinates coordinates){
        return colorizeSprite("   ");
    }
    private String getEntitySpite(Entity entity) {
        String nameClass = entity.getClass().getSimpleName();
        String sprite = "";
        if (nameClass.equals("StaticObject")) {
            StaticObject staticObject = (StaticObject) entity;
            String nature = String.valueOf(staticObject.getNature());
            sprite = switch (nature) {
                case "GRASS" -> " g ";
                case "TREE" -> " t ";
                case "STONE" -> " s ";
                default -> sprite;
            };
        } else if (nameClass.equals("Herbivore")) {
            sprite = " ● ";
        } else {
            sprite = " ▲ ";
        }
        sprite = colorizeSprite(sprite);
        return sprite;
    }
}
