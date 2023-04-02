package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caterpillar extends Animal {
//    public Caterpillar() {
//        super(0.01,1,0.0025,1);
//    }
public Caterpillar(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.CATERPILLAR;
    }
}
