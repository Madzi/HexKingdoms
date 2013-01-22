package ru.madzi.games.tools.config;

public class ConfigManager {

    private static final ConfigManager INSTANCE = new ConfigManager();

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        return INSTANCE;
    }

    private Config config;

    public Config getConfig() {
        return config;
    }

    public ConfigManager setConfig(Config config) {
        this.config = config;
        return this;
    }

}
