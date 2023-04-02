package entitys;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LiveableConfig {
    BigDecimal weight;
    Integer speed;
    BigDecimal food;
    Integer count;
    Integer lifetime;
}
