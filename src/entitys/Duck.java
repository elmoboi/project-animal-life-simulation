package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Duck extends Animal {
//    public Duck() {
//        super(1,1,0.15,4);
//    }
public Duck(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.DUCK;
    }
}
