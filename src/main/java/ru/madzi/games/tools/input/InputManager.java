package ru.madzi.games.tools.input;

import java.util.List;

import ru.madzi.games.tools.action.Action;

public interface InputManager {

    public static final int MOUSE_MOVE_LEFT = 0;
    public static final int MOUSE_MOVE_RIGHT = 1;
    public static final int MOUSE_MOVE_UP = 2;
    public static final int MOUSE_MOVE_DOWN = 3;
    public static final int MOUSE_WHEEL_UP = 4;
    public static final int MOUSE_WHEEL_DOWN = 5;
    public static final int MOUSE_BUTTON_1 = 6;
    public static final int MOUSE_BUTTON_2 = 7;
    public static final int MOUSE_BUTTON_3 = 8;

    public static final int MOUSE_SIZE = 9;
    public static final int KEYBOARD_SIZE = 600;

    public void mapToKey(Action action, int keyCode);

    public void mapToMouse(Action action, int mouseCode);

    public void clearMap(Action action);

    public List<String> getMaps(Action action);

    public void resetAllActions();

    public void clearAllMaps();

}
