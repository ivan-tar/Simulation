// Хищник
public class Predator extends Creature{
    int attackPower;
    Predator(int speed, int health, int attackPower) {
        super(speed, health);
        this.attackPower = attackPower;
    }

    @Override
    void makeMove() {}
}
