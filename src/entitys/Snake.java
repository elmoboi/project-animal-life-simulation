package entitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake extends Animal {
    //public Snake() {
//        super(2,1,0.3,15);
//    }
    public Snake(LiveableConfig liveableConfig) {
        super(liveableConfig);
    }

    @Override
    public LiveableType getLiveableType() {
        return LiveableType.SNAKE;
    }
}
