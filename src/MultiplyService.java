import entitys.Animal;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class MultiplyService {
    RandomManager randomManager = RandomManager.getRandomManager();


    public Optional<Animal> multiply(Animal animal) {
        ThreadLocalRandom random = randomManager.getRandom();
        int generateChance = random.nextInt(0,100);
        return Optional.of(animal)
                .filter(chance -> generateChance > 50);
        }
}
