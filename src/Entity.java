// Объект
abstract public class Entity {
    public Nature nature;
    public Coordinates coordinates;

    public Entity(Coordinates coordinates, Nature nature) {
        this.nature = nature;
        this.coordinates = coordinates;
    }

    public Entity(Coordinates coordinates){
        this.coordinates = coordinates;
    }
}
