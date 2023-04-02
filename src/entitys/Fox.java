package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox extends Animal {
//    public Fox() {
//        super(4,3,1,8);
//    }
public Fox(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.FOX;
    }
}
