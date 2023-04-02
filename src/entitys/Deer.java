package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deer extends Animal {
//    public Deer() {
//        super(170,3,26,4);
//    }
public Deer(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.DEER;
    }
}
