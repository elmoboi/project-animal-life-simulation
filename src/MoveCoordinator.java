import entitys.Animal;
import entitys.Entity;

import java.util.List;

public class MoveCoordinator {
    DirectionService directionService = new DirectionService();

    public void move(Animal animal, Cell cell, Field field) {
        List<Entity> animalList = cell.getListAnimal();
        final Direction direction = directionService.pickDirection(cell,animal.getSpeed());
        if(direction == Direction.DOWN) {
            field.getCells().get(cell.getX() + animal.getSpeed()).get(cell.getY()).getListAnimal().add(animal);
            animalList.remove(animal);
        } else if(direction == Direction.UP) {
            field.getCells().get(cell.getX() - animal.getSpeed()).get(cell.getY()).getListAnimal().add(animal);
            animalList.remove(animal);
        } else if(direction == Direction.LEFT) {
            field.getCells().get(cell.getX()).get(cell.getY() - animal.getSpeed()).getListAnimal().add(animal);
            animalList.remove(animal);
        } else if(direction == Direction.RIGHT) {
            field.getCells().get(cell.getX()).get(cell.getY() + animal.getSpeed()).getListAnimal().add(animal);
            animalList.remove(animal);
        }

    }
//    00 01 02
//    10 11 12
//    20 21 22

}
