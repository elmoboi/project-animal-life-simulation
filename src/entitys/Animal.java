package entitys;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Animal extends Entity {
    Integer speed;
    BigDecimal food;
    Integer lifeTime;

    public Animal(LiveableConfig liveableConfig) {
        super(liveableConfig);
        this.speed = liveableConfig.getSpeed();
        this.food = liveableConfig.getFood();
        this.lifeTime = liveableConfig.getLifetime();
    }

    public abstract LiveableType getLiveableType();

    @Override
    public String toString() {
        return "Animal{" +
                "speed=" + speed +
                ", food=" + food +
                ", lifeTime=" + lifeTime +
                '}';
    }
}
