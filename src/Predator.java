// Хищник
public class Predator extends Creature{
    int attackPower;

    public Predator(Status status, Coordinates coordinates, int speed, int health, int attackPower) {
        super(status, coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    void makeMove() {}
}
