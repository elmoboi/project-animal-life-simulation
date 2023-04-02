package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hare extends Animal {
//    public Hare() {
//        super(3,3,0.45,7);
//    }
public Hare(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.HARE;
    }
}
