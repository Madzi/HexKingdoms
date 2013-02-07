package ru.madzi.games.hedgehog.stages;

import org.lwjgl.input.Keyboard;
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
import ru.madzi.games.tools.stages.StageManager;

public class MenuStage implements Stage {

    public static final String NAME = "_menu";

    private Action finishAction = new Action("finish", Action.Behavior.DETECT_INITIAL_PRESS_ONLY);

    private Action selectAction = new Action("select");

    private Action upAction = new Action("up");

    private Action downAction = new Action("down");

    private boolean done;

    private Sprite background;

    private Sprite logo;

    private Sprite cursor;

    private Sprite nameMenu;

    private Sprite gameMenu;

    private Sprite optsMenu;

    private Sprite exitMenu;

    private Config config = ConfigManager.getInstance().getConfig();

    private ResourceManager resourceManager = ResourceManager.getInstance();

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getNextStageName() {
        return done ? StageManager.EXIT : null;
    }

    @Override
    public void start() {
        done = false;
        InputManager inputManager = InputManager.getInstance();
        inputManager.mapToKey(finishAction, config.getKeyEsc());
        inputManager.mapToKey(selectAction, config.getKeyFire());
        inputManager.mapToKey(upAction, config.getKeyUp());
        inputManager.mapToKey(downAction, config.getKeyDown());
    }

    @Override
    public void loadResources() {
        Animation animation = new Animation();
        Texture texture = resourceManager.loadTexture(Resources.IMAGE_MENU_BACKGROUND);
        animation.addFrame(texture, 10000);
        background = new Sprite(animation);

        animation = new Animation();
        texture = resourceManager.loadTexture(Resources.IMAGE_MENU_LOGO);
        animation.addFrame(texture, 10000);
        logo = new Sprite(animation);
        //TODO: calc coords

        animation = new Animation();
        texture = resourceManager.loadTexture(Resources.IMAGE_MENU_CURSOR);
        animation.addFrame(texture, 10000);
        cursor = new Sprite(animation);
        //TODO: calc coords

        animation = new Animation();
        texture = resourceManager.loadTexture(Resources.IMAGE_MENU_NAME);
        animation.addFrame(texture, 10000);
        nameMenu = new Sprite(animation);
        //TODO: calc coords

        animation = new Animation();
        texture = resourceManager.loadTexture(Resources.IMAGE_MENU_GAME);
        animation.addFrame(texture, 10000);
        gameMenu = new Sprite(animation);
        //TODO: calc coords

        animation = new Animation();
        texture = resourceManager.loadTexture(Resources.IMAGE_MENU_OPTION);
        animation.addFrame(texture, 10000);
        optsMenu = new Sprite(animation);
        //TODO: calc coords

        animation = new Animation();
        texture = resourceManager.loadTexture(Resources.IMAGE_MENU_EXIT);
        animation.addFrame(texture, 10000);
        exitMenu = new Sprite(animation);
        //TODO: calc coords
    }

    @Override
    public void update(long elapsedTime) {
        done = finishAction.isPressed();
    }

    @Override
    public void draw() {
        background.draw();
        logo.draw();
        nameMenu.draw();
        gameMenu.draw();
        optsMenu.draw();
        exitMenu.draw();
        cursor.draw();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

}
