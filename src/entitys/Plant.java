package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plant extends Entity {
    public Plant(LiveableConfig liveableConfig) {
        super(liveableConfig.getWeight());
    }

    @Override
    public LiveableType getLiveableType() {
        return LiveableType.PLANT;
    }
}
