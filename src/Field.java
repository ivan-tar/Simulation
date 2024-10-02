import java.util.HashMap;

public class Field {
    HashMap<Coordinates,Entity> entities = new HashMap<>();

    public void setEntities(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }
}
