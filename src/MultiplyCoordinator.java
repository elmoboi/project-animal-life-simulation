import entitys.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MultiplyCoordinator {
    MultiplyService multiplyService = new MultiplyService();
    AnimalAndPlantFactory animalAndPlantFactory = new AnimalAndPlantFactory();
    AnimalsConfig animalsConfig = ConfigManager.configManager.getAnimalsConfig();

    Map<LiveableType, Function<LiveableConfig, Entity>> generateEntity =
            Map.ofEntries(
                    Map.entry(LiveableType.WOLF, Wolf::new),
                    Map.entry(LiveableType.SNAKE, Snake::new),
                    Map.entry(LiveableType.SHEEP, Sheep::new),
                    Map.entry(LiveableType.PLANT, Plant::new),
                    Map.entry(LiveableType.KANGAROO, Kangaroo::new),
                    Map.entry(LiveableType.HORSE, Horse::new),
                    Map.entry(LiveableType.HAMSTER, Hamster::new),
                    Map.entry(LiveableType.HARE, Hare::new),
                    Map.entry(LiveableType.GOAT, Goat::new),
                    Map.entry(LiveableType.FOX, Fox::new),
                    Map.entry(LiveableType.EAGLE, Eagle::new),
                    Map.entry(LiveableType.DUCK, Duck::new),
                    Map.entry(LiveableType.DEER, Deer::new),
                    Map.entry(LiveableType.COW, Cow::new),
                    Map.entry(LiveableType.CATERPILLAR, Caterpillar::new),
                    Map.entry(LiveableType.BEAR, Bear::new)
            );

    public void multyplyEntity(Cell cell, Animal animal) {
        Optional<Animal> born = multiplyService.multiply(animal);
        LiveableType liveableType = animal.getLiveableType();
        born.ifPresent(animal1 -> cell.getListAnimal().add(animalAndPlantFactory.getInstance(liveableType, animalsConfig.getConfig().get(liveableType))));
    }
}
