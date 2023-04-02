package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat extends Animal {
//    public Goat() {
//        super(65,1,10,5);
//    }
public Goat(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.GOAT;
    }
}
