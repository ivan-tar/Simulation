// Существо
abstract public class Creature extends Entity {
    int speed;
    int health;


    public Creature(Status status, Coordinates coordinates, int speed, int health) {
        super(status, coordinates);
        status  = Status.NON_STATIC;
        this.speed = speed;
        this.health = health;
    }

    abstract void makeMove();


}
