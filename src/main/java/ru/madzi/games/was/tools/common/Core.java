package ru.madzi.games.was.tools.common;

import org.lwjgl.opengl.Display;

import ru.madzi.games.was.tools.graphics.ScreenManager;
import ru.madzi.games.was.tools.input.InputManager;
import ru.madzi.games.was.tools.stage.Stage;
import ru.madzi.games.was.tools.stage.StageManager;

import javax.xml.ws.Dispatch;

public class Core implements Managerable {

    private static final Core INSTANCE = new Core();

    private ResourceManager resourceManager = new ResourceManager();

    private ScreenManager screenManager = new ScreenManager();

    private InputManager inputManager = new InputManager();

    private StageManager stageManager = new StageManager(inputManager, resourceManager);

    private boolean done = true;

    private boolean error = false;

    private Core() {}

    public static final Core getInstance() {
        return INSTANCE;
    }

    public StageManager getStageManager() {
        return stageManager;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public void addStage(Stage stage) {
        stageManager.addStage(stage);
    }

    public void run() {
        init();
        loop();
        done();
    }

    public void init() {
        inputManager.init();
        screenManager.init();
        resourceManager.init();
    }

    public void poll() {
        if (Display.isCloseRequested()) {
            done = true;
        }
        inputManager.poll();
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
        long startTime = Timer.getTime();
        long currentTime = startTime;
        while (!done) {
            long elapsedTime = Timer.getTime() - currentTime;
            currentTime += elapsedTime;

            poll();

            update(elapsedTime);

            draw(screenManager);
        }
    }

    public boolean hasError() {
        return error;
    }

    public void done() {
        screenManager.done();
    }

}
