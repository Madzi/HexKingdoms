package ru.madzi.games.tools.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

import ru.madzi.games.tools.action.Action;

public class KeyboardDevice extends AbstractDevice {

    public void init() {
        maps = new Action[Keyboard.KEYBOARD_SIZE];
        try {
            Keyboard.create();
        } catch (LWJGLException ex) {
            error = true;
        }
    }

    public void done() {
        Keyboard.destroy();
    }

    @Override
    public String getName() {
        return "Keyboard";
    }

    @Override
    public String getKeyName(int key) {
        return Keyboard.getKeyName(key);
    }

}
