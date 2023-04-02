import entitys.LiveableConfig;
import entitys.LiveableType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnimalsConfig {
    Map<LiveableType, LiveableConfig> config;

}
