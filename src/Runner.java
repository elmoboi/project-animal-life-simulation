import entitys.Animal;
import entitys.Entity;
import entitys.LiveableType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Runner {
    MapConfig mapConfig = new MapConfig();
    IslandGenerator islandGenerator = new IslandGenerator();

    EatCoordinator eatCoordinator = new EatCoordinator();
    MultiplyCoordinator multiplyCoordinator = new MultiplyCoordinator();
    MoveCoordinator moveCoordinator = new MoveCoordinator();

    PlantGrowing plantGrowing = new PlantGrowing();

    public void start() {
        Field field = createField(mapConfig);
        islandGenerator.generateIsland(field);

        Runnable scheduleTask = () -> {

            islandGenerator.printIsland(field);
            System.out.println();
            plantGrowing.grow(field);


            Map<LiveableType, Long> collect = field.getCells()
                    .stream()
                    .flatMap(Collection::stream)
                    .flatMap(cell -> cell.getListAnimal().stream())
                    .collect(Collectors.groupingBy(Entity::getLiveableType, Collectors.counting()));

            for(Map.Entry<LiveableType, Long> entry : collect.entrySet()) {
                System.out.println(entry.getKey().name() + " " + entry.getValue());
            }
            System.out.println();
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        for(List<Cell> cellList : field.getCells()) {
            Runnable cellTask = () -> {
                for (Cell cell : cellList) {
                    List<Entity> entityList = cell.getListAnimal();
                    for (Entity entity : entityList) {
                        if (entity instanceof Animal animal) {
                            eatCoordinator.eatEntity(cell, animal);
                            multiplyCoordinator.multyplyEntity(cell, animal);
                            moveCoordinator.move(animal, cell, field);

                        }
                    }
                }
            };
            executorService.submit(cellTask);
        }
        scheduledExecutorService.scheduleWithFixedDelay(scheduleTask,5,15, TimeUnit.SECONDS);
    }

    private static Field createField(MapConfig mapConfig) {
        Field field = new Field();
        for(int i=0; i< mapConfig.getX(); i++) {
            field.getCells().add(new ArrayList<>());
            for(int j=0; j< mapConfig.getY(); j++) {
                field.getCells().get(i).add(new Cell(i,j));
            }
        }
        return field;
    }
}
