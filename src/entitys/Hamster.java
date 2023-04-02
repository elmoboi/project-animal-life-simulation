package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hamster extends Animal {
//    public Hamster() {
//        super(0.03,1,0.0075,3);
//    }
public Hamster(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.HAMSTER;
    }
}
