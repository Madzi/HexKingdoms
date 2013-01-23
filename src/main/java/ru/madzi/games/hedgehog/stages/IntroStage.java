package ru.madzi.games.hedgehog.stages;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;

import ru.madzi.games.tools.input.Action;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stages.Stage;
import ru.madzi.games.tools.stages.StageManager;

public class IntroStage implements Stage {

    public static final String NAME = "_intro";

    private static final long SHOW_TIME = 5 * Sys.getTimerResolution();

    private float alpha = 0f;

    private boolean done;

    private long showTime;

    private Action finishAction = new Action("finish", Action.Behavior.DETECT_INITIAL_PRESS_ONLY);

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
        InputManager.getInstance().mapToKey(finishAction, Keyboard.KEY_ESCAPE);
    }

    @Override
    public void loadResources() {
    }

    @Override
    public void update(long elapsedTime) {
        alpha += 0.1;
        showTime += elapsedTime;
        done = showTime > SHOW_TIME;
        done = done || finishAction.isPressed();
    }

    @Override
    public void draw() {
        glRotatef(alpha, 0, 0, 1);
        glBegin(GL_TRIANGLES);
        glVertex3f(-0.5f, -0.5f, 0);
        glVertex3f(0.5f, -0.5f, 0);
        glVertex3f(0, 0.5f, 0);
        glEnd();
    }

    @Override
    public void stop() {
    }

}
