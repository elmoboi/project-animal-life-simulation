package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cow extends Animal {
//    public Cow() {
//        super(350,1,53,4);
//    }
public Cow(LiveableConfig liveableConfig) {
    super(liveableConfig);
}
    @Override
    public LiveableType getLiveableType() {
        return LiveableType.COW;
    }
}
