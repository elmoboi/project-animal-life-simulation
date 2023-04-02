import entitys.Entity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RandomEatService {
    RandomManager randomManager = RandomManager.getRandomManager();

    public Entity chooseEntity(Cell cell, Entity entity) {
        List<Entity> entityList = cell.getListAnimal()
                .stream()
                .filter(e -> !e.getLiveableType().equals(entity.getLiveableType())).collect(Collectors.toList());
        ThreadLocalRandom random = randomManager.getRandom();
        int randomId = random.nextInt(0,entityList.size());
        return entityList.get(randomId);
    }
}
