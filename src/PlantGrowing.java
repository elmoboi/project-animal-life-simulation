import entitys.LiveableType;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PlantGrowing {
    RandomManager randomManager = RandomManager.getRandomManager();
    AnimalAndPlantFactory animalAndPlantFactory = new AnimalAndPlantFactory();
    AnimalsConfig animalsConfig = ConfigManager.configManager.getAnimalsConfig();

    public void grow(Field field) {
        ThreadLocalRandom random = randomManager.getRandom();

        field.getCells()
                .stream()
                .flatMap(Collection::stream)
                .forEach(
                        cell -> {
                            int i = random.nextInt(0,100);
                            IntStream.range(0,i)
                                    .forEach(j -> cell.getListAnimal()
                                            .add(animalAndPlantFactory.getInstance(LiveableType.PLANT,animalsConfig.getConfig().get(LiveableType.PLANT))));
                        }
                );
    }
}
