import entitys.Entity;
import entitys.LiveableType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EntityCreatorTest {
    AnimalsConfig animalsConfig = ConfigManager.getConfigManager().getAnimalsConfig();
    AnimalAndPlantFactory animalAndPlantFactory = new AnimalAndPlantFactory();
    RandomManager randomManager = RandomManager.getRandomManager();

    public List<Entity> createEntitiTest() {
        List<Entity> list = new ArrayList<>();
        LiveableType[] values = LiveableType.values();
        for(LiveableType value : values) {
            ThreadLocalRandom random = randomManager.getRandom();
            int randomCout = random.nextInt(0, animalsConfig.getConfig().get(value).getCount());
            for(int i = 0; i<randomCout; i++) {
                list.add(animalAndPlantFactory.getInstance(value, animalsConfig.getConfig().get(value)));
            }
        }
        Collections.shuffle(list);
        return list;
    }
}
