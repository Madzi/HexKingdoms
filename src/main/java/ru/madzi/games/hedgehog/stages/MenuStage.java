package ru.madzi.games.hedgehog.stages;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

import ru.madzi.games.tools.ResourceManager;
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
        inputManager.mapToKey(finishAction, Keyboard.KEY_ESCAPE);
        inputManager.mapToKey(selectAction, Keyboard.KEY_SPACE);
        inputManager.mapToKey(upAction, Keyboard.KEY_UP);
        inputManager.mapToKey(downAction, Keyboard.KEY_DOWN);
    }

    @Override
    public void loadResources() {
        Texture texture = ResourceManager.getInstance().loadTexture("images//8backscreen.png");
        Animation animation = new Animation();
        animation.addFrame(texture, 10000);
        background = new Sprite(animation);
        
    }

    @Override
    public void update(long elapsedTime) {
        done = finishAction.isPressed();
    }

    @Override
    public void draw() {
        background.draw();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

}
