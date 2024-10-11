package com.ivan_tar;// поле
import com.ivan_tar.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Field {
    HashMap<Coordinates, Entity> entities = new HashMap<>();
    private Random random = new Random();

    public void setEntities(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    // Метод для генерации случайных координат
    private Coordinates generateRandomCoordinates() {
        int x = random.nextInt(35);
        int y = random.nextInt(20);
        return new Coordinates(x, y);
    }

    private int[] generateRandomValues() {
        int speed = random.nextInt(3) + 1; // Случайная скорость от 1 до 3
        int health = random.nextInt(65) + 1; // Случайное здоровье от 1 до 65
        int attackPower = random.nextInt(20) + 1; // Случайная сила атаки
        return new int[]{speed, health, attackPower};
    }

    public void setupDefaultEntityPositions() {
        for (int i = 0; i < 15; i++) {
            Coordinates treeCoords = generateRandomCoordinates();

            while (!isSquareEmpty(treeCoords)) {
                treeCoords = generateRandomCoordinates();
            }

            setEntities(treeCoords, new StaticObject(treeCoords, Nature.TREE));
        }

        for (int i = 0; i < 15; i++) {
            Coordinates grassCoords = generateRandomCoordinates();

            while (!isSquareEmpty(grassCoords)) {
                grassCoords = generateRandomCoordinates();
            }

            setEntities(grassCoords, new StaticObject(grassCoords, Nature.GRASS));
        }

        for (int i = 0; i < 15; i++) {
            Coordinates stoneCoords = generateRandomCoordinates();

            while (!isSquareEmpty(stoneCoords)) {
                stoneCoords = generateRandomCoordinates();
            }

            setEntities(stoneCoords, new StaticObject(stoneCoords, Nature.STONE));
        }

        for (int i = 0; i < 15; i++) {
            Coordinates herbivoreCoords = generateRandomCoordinates();
            int[] randomValues = generateRandomValues();
            int speed = randomValues[0];
            int health = randomValues[1];

            while (!isSquareEmpty(herbivoreCoords)) {
                herbivoreCoords = generateRandomCoordinates();
            }

            setEntities(herbivoreCoords, new Herbivore(herbivoreCoords, speed, health));
        }

        for (int i = 0; i < 15; i++) {
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
