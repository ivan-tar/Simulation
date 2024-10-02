import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Field {
    HashMap<Coordinates,Entity> entities = new HashMap<>();

    public void setEntities(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }





    public void setupDefaultEntityPositions(){
        List<Integer> initialValues =new ArrayList<>();

        initialValues.add(30); // max x
        initialValues.add(50); // max y
        initialValues.add(5);   // speed 5
        initialValues.add(60);   // HP 60

        for (int i = 0; i < 10; i++) {

            int x = (int) (Math.random() * initialValues.get(1));
            int y = (int) (Math.random() * initialValues.get(2));
            int speed = (int) (Math.random() * initialValues.get(3));
            int health = (int) (Math.random() * initialValues.get(4));

            setEntities(new Coordinates(x,y) ,new Herbivore(Status.NON_STATIC,new Coordinates(x,y),speed,health));
        }
    }
}
