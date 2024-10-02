// Существо
abstract public class Creature extends Entity {
    int speed;
    int health;


    public Creature(Coordinates coordinates, int speed, int health) {
        super(coordinates);
        this.speed = speed;
        this.health = health;
    }

    // для каждого существа своя реализация
    abstract void makeMove();


}
