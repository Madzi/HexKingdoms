package ru.madzi.games.tools.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;

import ru.madzi.games.tools.action.Action;

public class MouseDevice extends AbstractDevice {

    public void init() {
        maps = new Action[10];
        try {
            Mouse.create();
        } catch (LWJGLException ex) {
            error = true;
        }
    }

    public void done() {
        Mouse.destroy();
    }

    @Override
    public String getName() {
        return "Mouse";
    }

    @Override
    public String getKeyName(int key) {
        return null;
    }

}
