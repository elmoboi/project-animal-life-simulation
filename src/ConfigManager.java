import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigManager {
    static volatile ConfigManager configManager;

    EatingChanceConfig eatingChanceConfig;
    AnimalsConfig animalsConfig;

    public ConfigManager(AnimalsConfig animalsConfig, EatingChanceConfig eatingChanceConfig) {
        this.animalsConfig = animalsConfig;
        this.eatingChanceConfig = eatingChanceConfig;
    }

    public static ConfigManager getConfigManager() {
        if(configManager == null) {
            synchronized (ConfigManager.class) {
                if(configManager == null) {
                    configManager = new ConfigManager(
                            ConfigReader.readConfig(Constants.ANIMAL_PROPERTIES_FILE_PATH, AnimalsConfig.class),
                            ConfigReader.readConfig(Constants.EATING_CHANCE_PROPERTIES_FILE_PATH, EatingChanceConfig.class)
                    );
                }
            }
        }
        return configManager;
    }

}
