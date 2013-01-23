package ru.madzi.games.hedgehog;

import ru.madzi.games.hedgehog.stages.IntroStage;
import ru.madzi.games.hedgehog.stages.MenuStage;
import ru.madzi.games.tools.Engine;
import ru.madzi.games.tools.config.Config;
import ru.madzi.games.tools.config.ConfigManager;
import ru.madzi.games.tools.stages.Stage;
import ru.madzi.games.tools.stages.StageManager;

public class App extends Engine {

    @Override
    public void configure() {
        ConfigManager.getInstance().setConfig(new Config());
        ConfigManager
            .getInstance()
            .getConfig()
            .setWidth(800)
            .setHeight(600)
            .setTitle("TEST")
            .setFullscreen(false)
            .setUseSync(true)
            .setSyncFps(100);
    }

    @Override
    public void initStages() {
        Stage introStage = new IntroStage();
        StageManager.getInstance().addStage(introStage);
        StageManager.getInstance().addStage(new MenuStage());
        StageManager.getInstance().setStage(introStage.getName());
    }

    public static void main(String[] args) {
        new App().run();
    }

}
