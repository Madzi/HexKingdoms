package ru.madzi.games.tools.common;

import ru.madzi.games.tools.graphics.ScreenManager;
import ru.madzi.games.tools.graphics.SwingScreenManager;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.input.SwingInputManager;
import ru.madzi.games.tools.stage.BaseStageManager;
import ru.madzi.games.tools.stage.Stage;
import ru.madzi.games.tools.stage.StageManager;

public class Core {

    private Mode mode;

    private ResourceManager resourceManager;

    private ScreenManager screenManager;

    private InputManager inputManager;

    private StageManager stageManager;

    private boolean done = false;

    public void addStage(Stage stage) {
        stageManager.addStage(stage);
    }

    public Core(Mode mode) {
        this.mode = mode;
    }

    public boolean init() {
        if (Mode.SWING == mode) {
            resourceManager = null;
            screenManager = new SwingScreenManager();
            inputManager = new SwingInputManager();
            stageManager = new BaseStageManager(inputManager, resourceManager);
            return true;
        }
        return false;
    }

    public void run() {
        loop();
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

    public void loop() {
        long startTime = getTime();
        long currentTime = startTime;
        while (!done) {
            long elapsedTime = getTime() - currentTime;
            currentTime += elapsedTime;
            update(elapsedTime);
            draw(screenManager);
        }
    }

    public static long getTime() {
        return System.nanoTime();
    }

}
