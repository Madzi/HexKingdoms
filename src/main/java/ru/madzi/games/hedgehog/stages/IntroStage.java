package ru.madzi.games.hedgehog.stages;

import org.lwjgl.Sys;
import org.newdawn.slick.opengl.Texture;

import ru.madzi.games.hedgehog.tools.Resources;
import ru.madzi.games.tools.ResourceManager;
import ru.madzi.games.tools.config.Config;
import ru.madzi.games.tools.config.ConfigManager;
import ru.madzi.games.tools.graphics.Animation;
import ru.madzi.games.tools.graphics.Sprite;
import ru.madzi.games.tools.input.Action;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stages.Stage;

public class IntroStage implements Stage {

    public static final String NAME = "_intro";

    private static final long SHOW_TIME = 5 * Sys.getTimerResolution();

    private boolean done;

    private long showTime;

    private Sprite background;

    private Sprite logo;

    private Action continueAction = new Action("continue", Action.Behavior.DETECT_INITIAL_PRESS_ONLY);

    private Config config = ConfigManager.getInstance().getConfig();

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getNextStageName() {
        return done ? MenuStage.NAME : null;
    }

    @Override
    public void start() {
        showTime = 0;
        done = false;
        InputManager.getInstance().mapToKey(continueAction, config.getKeyEsc());
        InputManager.getInstance().mapToKey(continueAction, config.getKeyFire());
    }

    @Override
    public void loadResources() {
        int width = config.getWidth();
        int height = config.getHeight();

        Animation animation = new Animation();
        Texture texture = ResourceManager.getInstance().loadTexture(Resources.IMAGE_INTRO_BACKGROUND);
        animation.addFrame(texture, 10000);
        background = new Sprite(animation);

        animation = new Animation();
        texture = ResourceManager.getInstance().loadTexture(Resources.IMAGE_INTRO_LOGO);
        animation.addFrame(texture, 10000);
        logo = new Sprite(animation);
        logo.setX((width - texture.getImageWidth()) / 2).setY((height - texture.getImageHeight()) / 2);
    }

    @Override
    public void update(long elapsedTime) {
        showTime += elapsedTime;
        done = showTime > SHOW_TIME;
        done = done || continueAction.isPressed();
    }

    @Override
    public void draw() {
        background.draw();
        logo.draw();
    }

    @Override
    public void stop() {
    }

}
