package ru.madzi.games.tools;

import java.awt.DisplayMode;

import ru.madzi.games.tools.common.Configuration;
import ru.madzi.games.tools.common.Mode;
import ru.madzi.games.tools.common.ResourceManager;
import ru.madzi.games.tools.graphics.ScreenManager;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stage.BaseStageManager;
import ru.madzi.games.tools.stage.Stage;
import ru.madzi.games.tools.stage.StageManager;

public class Core {

    private Configuration configuration = new Configuration();

    private Mode mode;

    private ResourceManager resourceManager;

    private ScreenManager screenManager;

    private InputManager inputManager;

    private StageManager stageManager;

    private boolean done = false;

    private boolean showFps = true;

    public void addStage(Stage stage) {
        if (stageManager != null) {
            stageManager.addStage(stage);
        }
    }

    public void setStage(String name) {
        if (stageManager != null) {
            stageManager.setStage(name);
        }
    }

    public Core(Mode mode) {
        this.mode = mode;
    }

    public boolean init() {
        if (Mode.SWING == mode) {
            resourceManager = new ru.madzi.games.tools.common.swing.ResourceManager();
            screenManager = new ru.madzi.games.tools.common.swing.ScreenManager();
            screenManager.setFullscreen(configuration.isFullscreen());
            screenManager.setTitle(configuration.getTitle());
            screenManager.create(new DisplayMode(configuration.getWidth(), 
                                                 configuration.getHeight(), 
                                                 DisplayMode.BIT_DEPTH_MULTI, 
                                                 DisplayMode.REFRESH_RATE_UNKNOWN));
            inputManager = new ru.madzi.games.tools.common.swing.InputManager(screenManager.getWindow());
            stageManager = new BaseStageManager(inputManager, resourceManager);
            return true;
        }
        return false;
    }

    public void update(long elapsedTime) {
        if (stageManager.isDone()) {
            done = true;
        } else {
            stageManager.update(elapsedTime);
        }
    }

    public void draw(ScreenManager screenManager) {
        stageManager.draw(screenManager);
        screenManager.update();
    }

    public void run() {
        long startTime = getTime();
        long currentTime = startTime;
        while (!done) {
            long elapsedTime = getTime() - currentTime;
            currentTime += elapsedTime;
            update(elapsedTime);
            draw(screenManager);
            if (showFps) {
                screenManager.getWindow().setTitle(screenManager.getTitle() + " [FPS: " + getFps(elapsedTime) + "]");
            }
            if (stageManager.isDone()) {
                done = true;
            }
        }
    }

    public void done() {
        screenManager.destroy();
    }

    public static double getFps(long elapsedTime) {
        return elapsedTime == 0 ? getTimerResolutioin() : ((double) getTimerResolutioin()) / elapsedTime;
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }

    public static long getTimerResolutioin() {
        return 1000;
    }

}
