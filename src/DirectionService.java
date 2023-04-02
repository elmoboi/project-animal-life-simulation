import entitys.Animal;
import entitys.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DirectionService {
    MapConfig mapConfig = new MapConfig();
    RandomManager randomManager = RandomManager.getRandomManager();

    public Direction pickDirection(Cell cell, int speed) {
        List<Direction> rightDirection = new ArrayList<>(List.of(Direction.UP, Direction.RIGHT, Direction.LEFT, Direction.DOWN));

        if(speed > mapConfig.getX() - cell.getX()){
            rightDirection.remove(Direction.RIGHT);
        } else if(speed < mapConfig.getX() - cell.getX()) {
            rightDirection.remove(Direction.LEFT);
        }
        if(speed > mapConfig.getY() - cell.getY()) {
            rightDirection.remove(Direction.DOWN);
        } else if(speed < mapConfig.getY() - cell.getY()) {
            rightDirection.remove(Direction.UP);
        }

        Direction oneDirection = rightDirection.get(randomManager.getRandom().nextInt(0, rightDirection.size()));

        return oneDirection;
    }
}
