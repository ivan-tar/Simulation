package com.ivan_tar;
import com.ivan_tar.entities.*;
import com.ivan_tar.enums.*;

import java.util.*;

// поле
public class Field {
    HashMap<Coordinates, Entity> entities = new HashMap<>();
    private Random random = new Random();

    public HashMap<Coordinates, Entity> getEntities() {
        for (Map.Entry<Coordinates, Entity> entry : entities.entrySet()) {
            Coordinates coord = entry.getKey();
            Entity entity = entry.getValue();

            if (!entity.getClass().getSimpleName().equals("StaticObject")){
                System.out.println(getAvailableFieldsToMove(entity).size() + " " + entity.getClass().getSimpleName() + " [" + coord.getVertical() + "," + coord.getHorizontal() + "] "  + getPriorityFields(entity).size());
            }

//            getAvailableFieldsToMove(entity);

//            System.out.println(getPriorityFields(entity).size() + " " + entity.getClass().getSimpleName());
        }
        return entities;
    }

    public void setEntities(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    // является ли клетка пустой
    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    // может ли объект двигаться
    private boolean isEntityMovable(Entity entity) {
        return (entity instanceof Herbivore) || (entity instanceof Predator);
    }

    // является ли клетка доступной для перемещения
    private boolean isValidMove(Coordinates potentialMove, Coordinates currentCoordinates) {
        return isWithinBounds(potentialMove) && isSquareEmpty(potentialMove) && !potentialMove.equals(currentCoordinates);
    }

    // находится ли клетка в пределах игрового поля
    private boolean isWithinBounds(Coordinates coordinates) {
        return coordinates.getHorizontal() > 0 && coordinates.getHorizontal() <= GameVariables.MAX_X.getValue()
                && coordinates.getVertical() > 0 && coordinates.getVertical() <= GameVariables.MAX_Y.getValue();
    }

    // получить доступные поля для перемещения
    public Set<Coordinates> getAvailableFieldsToMove(Entity entity) {
        Set<Coordinates> availableFields = new HashSet<>();
        if (isEntityMovable(entity)) {
            Coordinates currentCoordinates = entity.coordinates;
            int speed = ((Creature) entity).getSpeed();
            for (int x =currentCoordinates.getHorizontal()-speed; x<=currentCoordinates.getHorizontal()+speed; x++){
                for (int y = currentCoordinates.getVertical()-speed; y<=currentCoordinates.getVertical()+speed; y++){
                    Coordinates potentialMove = new Coordinates(x,y);
                    if (isValidMove(potentialMove, currentCoordinates)){
                        availableFields.add(potentialMove);
                    }
                }
            }
        }
        return availableFields;
    }

    //получить приоритетное поле
    public Set<Coordinates> getPriorityFields(Entity entity) {
        Set<Coordinates> priorityFields = new HashSet<>();
        Coordinates currentCoordinates = entity.coordinates;

        if (entity instanceof Creature creature) {
            int speed = creature.getSpeed();

            for (int x = currentCoordinates.getHorizontal() - speed; x <= currentCoordinates.getHorizontal() + speed; x++) {
                for (int y = currentCoordinates.getVertical() - speed; y <= currentCoordinates.getVertical() + speed; y++) {
                    Coordinates potentialCoordinates = new Coordinates(x, y);

                    // клетка в пределах игрового поля
                    if (isWithinBounds(potentialCoordinates)) {
                        Entity target = entities.get(potentialCoordinates);

                        // Логика для хищника
                        if (entity instanceof Predator && target instanceof Herbivore) {
                            priorityFields.add(potentialCoordinates);
                        }

                        // Логика для травоядного
                        else if (entity instanceof Herbivore) {
                            // Проверяем, является ли цель хищником
                            if (target instanceof Predator) {
                                priorityFields.add(potentialCoordinates);
                            }
                            // Проверяем, является ли цель статическим объектом и получаем его
                            if (target instanceof StaticObject targetStatic) {
                                // Проверяем, является ли статический объект травой
                                if (targetStatic.getNature().equals(Nature.GRASS)) {
                                    priorityFields.add(potentialCoordinates);
                                }
                            }
                        }
                    }
                }
            }
        }
        return priorityFields;
    }

    // генерация случайных координат
    private Coordinates generateRandomCoordinates() {
        int x = random.nextInt(GameVariables.MAX_X.getValue()) + 1;
        int y = random.nextInt(GameVariables.MAX_Y.getValue()) + 1;
        return new Coordinates(x, y);
    }

    // Метод для генерации случайных значений объектов
    private int[] generateRandomValues() {
        int speed = random.nextInt(GameVariables.SPEED.getValue()) + 1;
        int health = random.nextInt(GameVariables.HEALTH.getValue()) + 1;
        int attackPower = random.nextInt(GameVariables.ATTACK_POWER.getValue()) + 1;
        return new int[]{speed, health, attackPower};
    }

    public void setupDefaultEntityPositions() {
        for (int i = 0; i < GameVariables.NUMBER_OF_ENEMIES.getValue(); i++) {
            Coordinates treeCoords = generateRandomCoordinates();

            while (!isSquareEmpty(treeCoords)) {
                treeCoords = generateRandomCoordinates();
            }

            setEntities(treeCoords, new StaticObject(treeCoords, Nature.TREE));
        }

        for (int i = 0; i < GameVariables.NUMBER_OF_ENEMIES.getValue(); i++) {
            Coordinates grassCoords = generateRandomCoordinates();

            while (!isSquareEmpty(grassCoords)) {
                grassCoords = generateRandomCoordinates();
            }

            setEntities(grassCoords, new StaticObject(grassCoords, Nature.GRASS));
        }

        for (int i = 0; i < GameVariables.NUMBER_OF_ENEMIES.getValue(); i++) {
            Coordinates stoneCoords = generateRandomCoordinates();

            while (!isSquareEmpty(stoneCoords)) {
                stoneCoords = generateRandomCoordinates();
            }

            setEntities(stoneCoords, new StaticObject(stoneCoords, Nature.STONE));
        }

        for (int i = 0; i < GameVariables.NUMBER_OF_ENEMIES.getValue(); i++) {
            Coordinates herbivoreCoords = generateRandomCoordinates();
            int[] randomValues = generateRandomValues();
            int speed = randomValues[0];
            int health = randomValues[1];

            while (!isSquareEmpty(herbivoreCoords)) {
                herbivoreCoords = generateRandomCoordinates();
            }

            setEntities(herbivoreCoords, new Herbivore(herbivoreCoords, speed, health));
        }

        for (int i = 0; i < GameVariables.NUMBER_OF_ENEMIES.getValue(); i++) {
            Coordinates predatorCoords = generateRandomCoordinates();
            int[] randomValues = generateRandomValues();
            int speed = randomValues[0];
            int health = randomValues[1];
            int attackPower = randomValues[2];

            while (!isSquareEmpty(predatorCoords)) {
                predatorCoords = generateRandomCoordinates();
            }

            setEntities(predatorCoords, new Predator(predatorCoords, speed, health, attackPower));
        }
    }
}
