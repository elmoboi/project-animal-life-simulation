import java.util.List;

public class PickRandomDirectionService {
    RandomManager randomManager = RandomManager.getRandomManager();
    public Direction pickRandom(List<Direction> listDirection) {
        Direction oneDirection;
        oneDirection = listDirection.get(randomManager.getRandom().nextInt(0,listDirection.size()));
        return oneDirection;
    }
}
