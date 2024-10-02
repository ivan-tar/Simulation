// Хищник
public class Predator extends Creature{
    int attackPower;

    public Predator(Coordinates coordinates, int speed, int health, int attackPower) {
        super(coordinates, speed, health);
        this.attackPower = attackPower;
    }

    @Override
    void makeMove() {}
}
