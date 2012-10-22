package ru.madzi.games.hexkingdoms.stage;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import ru.madzi.games.tools.action.Action;
import ru.madzi.games.tools.common.ResourceManager;
import ru.madzi.games.tools.graphics.ScreenManager;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stage.Stage;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class Intro implements Stage {

    private Image backscreen;

    private long waitingTime = 5000;

    private Action finish = new Action("Finish");

    private boolean done;

    public String getName() {
        return "_intro";
    }

    public String checkForStageChange() {
        return done ? Stage.EXIT : null;
    }

    public void loadResources(ResourceManager resourceManager) {
        backscreen = resourceManager.loadImage("images/backgame.png");
    }

    public void start(InputManager inputManager) {
        inputManager.mapToKey(finish, KeyEvent.VK_ESCAPE);
    }

    public void stop() {
    }

    public void update(long elapsedTime) {
        if (finish.isPressed()) {
            done = true;
        }
        waitingTime -= elapsedTime;
        if (waitingTime < 0) {
            done = true;
        }
    }

    public void draw(ScreenManager screenManager) {
        screenManager.getGraphics().fillRect(0, 0, 50, 50);
    }
}
