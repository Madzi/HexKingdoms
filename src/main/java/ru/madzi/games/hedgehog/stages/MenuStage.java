package ru.madzi.games.hedgehog.stages;

import org.lwjgl.input.Keyboard;

import ru.madzi.games.tools.input.Action;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stages.Stage;
import ru.madzi.games.tools.stages.StageManager;

public class MenuStage implements Stage {

    public static final String NAME = "_menu";

    private Action finishAction = new Action("finish", Action.Behavior.DETECT_INITIAL_PRESS_ONLY);

    private boolean done;

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
        InputManager.getInstance().mapToKey(finishAction, Keyboard.KEY_ESCAPE);
    }

    @Override
    public void loadResources() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(long elapsedTime) {
        done = finishAction.isPressed();
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

}
