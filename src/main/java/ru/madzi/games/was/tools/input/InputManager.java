package ru.madzi.games.was.tools.input;

import java.util.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import ru.madzi.games.tools.action.Action;
import ru.madzi.games.was.tools.common.AbstractManager;

public class InputManager extends AbstractManager {

    public static final int MOUSE_MOVE_LEFT = 0;
    public static final int MOUSE_MOVE_RIGHT = 1;
    public static final int MOUSE_MOVE_UP = 2;
    public static final int MOUSE_MOVE_DOWN = 3;
    public static final int MOUSE_WHEEL_UP = 4;
    public static final int MOUSE_WHEEL_DOWN = 5;
    public static final int MOUSE_BUTTON_1 = 6;
    public static final int MOUSE_BUTTON_2 = 7;
    public static final int MOUSE_BUTTON_3 = 8;

    private static final int MOUSE_SIZE = 9;

    private static final String[] MOUSE_NAMES = {
            "Mouse Left",
            "Mouse Right",
            "Mouse Up",
            "Mouse Down",
            "Mouse Wheel Up",
            "Mouse Wheel Down",
            "Mouse Button 1",
            "Mouse Button 2",
            "Mouse Button 3"
    };

    private Action[] keyActions;
    private Action[] mouseActions;
    private Action[] joyActions;

    public void init() {
        keyActions = new Action[Keyboard.KEYBOARD_SIZE];
        mouseActions = new Action[MOUSE_SIZE];
        try {
            Keyboard.create();
            Mouse.create();
        } catch (LWJGLException ex) {
            error = true;
        }
    }

    public void done() {
        Mouse.destroy();
        Keyboard.destroy();
    }

    public void mapToKey(Action action, int keyCode) {
        keyActions[keyCode] = action;
    }

    public void mapToMouse(Action action, int mouseCode) {
        mouseActions[mouseCode] = action;
    }

    public void clearMap(Action action) {
        for (int keyCode = 0; keyCode < keyActions.length; ++keyCode) {
            if (keyActions[keyCode] == action) {
                keyActions[keyCode] = null;
            }
        }
        for (int mouseCode = 0; mouseCode < mouseActions.length; ++mouseCode) {
            if (mouseActions[mouseCode] == action) {
                mouseActions[mouseCode] = null;
            }
        }
        action.reset();
    }
    public List<String> getMaps(Action action) {
        List<String> maps = new ArrayList<String>();
        for (int keyCode = 0; keyCode < keyActions.length; ++keyCode) {
            if (keyActions[keyCode] == action) {
                maps.add("KEYBOARD: " + getKeyName(keyCode));
            }
        }
        for (int mouseCode = 0; mouseCode < mouseActions.length; ++mouseCode) {
            if (mouseActions[mouseCode] == action) {
                maps.add("MOUSE: " + getMouseName(mouseCode));
            }
        }
        return maps;
    }

    public void resetAllActions() {
        for (int keyCode = 0; keyCode < keyActions.length; ++keyCode) {
            if (keyActions[keyCode] != null) {
                keyActions[keyCode].reset();
            }
        }
        for (int mouseCode = 0; mouseCode < mouseActions.length; ++mouseCode) {
            if (mouseActions[mouseCode] != null) {
                mouseActions[mouseCode].reset();
            }
        }
    }

    public void clearAllMaps() {
        for (int keyCode = 0; keyCode < keyActions.length; ++keyCode) {
            keyActions[keyCode] = null;
        }
        for (int mouseCode = 0; mouseCode < mouseActions.length; ++mouseCode) {
            mouseActions[mouseCode] = null;
        }
    }

    public static String getKeyName(int keyCode) {
        return Keyboard.getKeyName(keyCode);
    }

    public static String getMouseName(int mouseCode) {
        return MOUSE_NAMES[mouseCode];
    }

    public void poll() {

    }

    private void mouseHelper(int codeNeg, int codePos, int amount) {
        Action action;
        if (amount < 0) {
            action = mouseActions[codeNeg];
        } else {
            action = mouseActions[codePos];
        }
        if (action != null) {
            action.press(Math.abs(amount));
            action.release();
        }
    }

}
