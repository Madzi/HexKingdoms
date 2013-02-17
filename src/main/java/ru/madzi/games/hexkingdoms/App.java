package ru.madzi.games.hexkingdoms;

import org.lwjgl.util.generator.GLenum;

import ru.madzi.games.tools.Engine;
import ru.madzi.games.tools.config.Config;
import ru.madzi.games.tools.config.ConfigManager;

public class App extends Engine {

    

    @Override
    public void configure() {
        configManager.setConfig(new Config()
            .setWidth(800)
            .setHeight(600)
            .setTitle("HexKingdom")
            .setFullscreen(false)
            .setUseSync(true)
            .setSyncFps(100));
    }

    @Override
    public void initGL() {
        Config config = configManager.getConfig();
    }

}
