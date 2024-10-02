// Объект
abstract public class Entity {
    public final Status status;
    public Coordinates coordinates;

    public Entity(Status status, Coordinates coordinates) {
        this.status = status;
        this.coordinates = coordinates;
    }
}
