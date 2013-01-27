package ru.madzi.games.tools;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

import ru.madzi.games.tools.config.ConfigManager;
import ru.madzi.games.tools.graphics.ScreenManager;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stages.StageManager;

public abstract class Engine {

    protected ConfigManager configManager = ConfigManager.getInstance();

    protected ScreenManager screenManager = ScreenManager.getInstance();

    protected StageManager stageManager = StageManager.getInstance();

    protected InputManager inputManager = InputManager.getInstance();

    private boolean done;

    public abstract void configure();

    public abstract void initGL();

    public abstract void initStages();

    public void run() {
        init();
        loop();
        stop();
    }

    private void init() {
        configure();
        try {
            screenManager.init();
            inputManager.init();
            stageManager.init();
        }
        catch (LWJGLException e) {
            e.printStackTrace();
            //TODO: LOG & EXIT
        }
        initGL();
        initStages();
        done = false;
    }

    private void loop() {
        long startTime = Sys.getTime();
        long currTime = startTime;
        while (!done) {
            long elapsedTime = Sys.getTime() - currTime;
            currTime += elapsedTime;
            update(elapsedTime);
            draw();
        }
    }

    private void update(long elapsedTime) {
        if (stageManager.isDone() || screenManager.isDone()) {
            done = true;
        } else {
            stageManager.update(elapsedTime);
        }
        inputManager.update();
    }

    private void draw() {
        screenManager.beforeDraw();
        stageManager.draw();
        screenManager.afterDraw();
    }

    private void stop() {
        stageManager.stop();
        inputManager.stop();
        screenManager.stop();
    }

}
