package entitys;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
public abstract class Entity {
    BigDecimal weight;
    public Entity(LiveableConfig liveableConfig) {
        this(liveableConfig.getWeight());
    }
    public abstract LiveableType getLiveableType();
}
