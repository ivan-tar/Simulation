// Существо
abstract public class Creature extends Entity {
    int speed;
    int health;


    Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    abstract void makeMove();


}
