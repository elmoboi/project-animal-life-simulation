import entitys.*;

import java.util.Map;
import java.util.function.Function;

public class AnimalAndPlantFactory {

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

    public Entity getInstance(LiveableType liveableType, LiveableConfig liveableConfig) {
        Function<LiveableConfig, Entity> function = generateEntity.get(liveableType);
        return function.apply(liveableConfig);
    }
}
