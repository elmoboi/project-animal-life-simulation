import entitys.Animal;
import entitys.Entity;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class EatService {
    EatingChanceConfig eatingChanceConfig = ConfigManager.getConfigManager().getEatingChanceConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Optional<Entity> eat(Animal who, Entity whom) {
        Integer animalEatingChance = eatingChanceConfig.getConfig().get(who.getLiveableType()).get(whom.getLiveableType());

        ThreadLocalRandom random = randomManager.getRandom();
        int generateChance = random.nextInt(0,100);
        return Optional.of(who)
                .filter(animal -> generateChance > animalEatingChance)
                .map(obj -> {
                    obj.setFood(whom.getWeight());
                    return whom;
                });
    }
}
