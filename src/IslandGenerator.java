import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IslandGenerator {
    MapConfig mapConfig = new MapConfig();
    EntityCreatorTest entityCreatorTest = new EntityCreatorTest();

    public void generateIsland(Field field) {
        for (int i=0; i < mapConfig.getX(); i++) {
            for (int j=0; j < mapConfig.getY(); j++) {
                field.getCells().get(i).get(j).getListAnimal().addAll(entityCreatorTest.createEntitiTest());
            }
        }
    }
    public void printIsland(Field field) {
        for (int i = 0; i < mapConfig.getX(); i++) {
            for (int j=0; j < mapConfig.getY(); j++) {
                System.out.print(" " + field.getCells().get(i).get(j).getListAnimal().size() + " ");
            }
            System.out.println();
        }
    }
}
