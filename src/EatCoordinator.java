import entitys.Animal;
import entitys.Entity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EatCoordinator {
    EatService eatService = new EatService();
    RandomEatService randomFoodService = new RandomEatService();

    public void eatEntity(Cell cell, Animal animal) {
        Entity entityObj = randomFoodService.chooseEntity(cell, animal);
        eatService.eat(animal, entityObj).ifPresent(e -> cell.getListAnimal().remove(e));
    }
}
