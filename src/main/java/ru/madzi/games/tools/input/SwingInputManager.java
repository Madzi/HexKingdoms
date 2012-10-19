package ru.madzi.games.tools.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import ru.madzi.games.tools.action.Action;

public class SwingInputManager implements InputManager {

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
                maps.add("KEYBOARD: " + KeyEvent.getKeyText(keyCode));
            }
        }
        for (int mouseCode = 0; mouseCode < mouseActions.length; ++mouseCode) {
            if (mouseActions[mouseCode] == action) {
                maps.add("MOUSE: " + MOUSE_NAMES[mouseCode]);
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
