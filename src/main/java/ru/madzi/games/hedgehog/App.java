package ru.madzi.games.hedgehog;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;
import ru.madzi.games.hedgehog.stages.AnalisysStage;
import ru.madzi.games.hedgehog.stages.GameStage;
import ru.madzi.games.hedgehog.stages.IntroStage;
import ru.madzi.games.hedgehog.stages.MenuStage;
import ru.madzi.games.hedgehog.stages.RecordsStage;
import ru.madzi.games.hedgehog.stages.SetupStage;
import ru.madzi.games.tools.Engine;
import ru.madzi.games.tools.config.Config;
import ru.madzi.games.tools.stages.Stage;
import ru.madzi.games.tools.stages.StageManager;

public class App extends Engine {

    @Override
    public void configure() {
        configManager.setConfig(new Config()
            .setWidth(800)
            .setHeight(600)
            .setTitle("TEST")
            .setFullscreen(false)
            .setUseSync(true)
            .setSyncFps(100));
    }

    @Override
    public void initGL() {
        Config config = configManager.getConfig();
        glEnable(GL_TEXTURE_2D);
        glClearColor(0f, 0f, 0f, 0f);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glViewport(0, 0, config.getWidth(), config.getHeight());
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, config.getWidth(), 0, config.getHeight(), 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    @Override
    public void initStages() {
        Stage introStage = new IntroStage();
        StageManager stageManager = StageManager.getInstance();
        stageManager.addStage(introStage);
        stageManager.addStage(new MenuStage());
        stageManager.addStage(new SetupStage());
        stageManager.addStage(new GameStage());
        stageManager.addStage(new RecordsStage());
        stageManager.addStage(new AnalisysStage());
        stageManager.loadAllResources();
        stageManager.setStage(introStage.getName());
    }

    public static void main(String[] args) {
        new App().run();
    }

}
