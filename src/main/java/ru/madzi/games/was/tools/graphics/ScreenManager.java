package ru.madzi.games.was.tools.graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import ru.madzi.games.was.tools.common.AbstractManager;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class ScreenManager extends AbstractManager {

    public boolean isActive() {
        return Display.isActive();
    }

    public void init() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException ex) {
            error = true;
        }
    }

    public void update() {
        Display.update();
    }

    public boolean needRender() {
        return Display.isVisible() || Display.isDirty();
    }

    public void done() {
        Display.destroy();
    }

}
