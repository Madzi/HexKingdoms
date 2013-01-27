package ru.madzi.games.tools.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public class InputManager {

    private static final InputManager INSTANCE = new InputManager();

    private InputManager() {}

    public static InputManager getInstance() {
        return INSTANCE;
    }

    private Map<Integer, Action> keyActions = new HashMap<Integer, Action>();

    public void init() throws LWJGLException {
        Keyboard.create();
    }

    public void mapToKey(Action action, int code) {
        keyActions.put(Integer.valueOf(code), action);
    }

    public void clearMap(Action action) {
        Iterator<Map.Entry<Integer, Action>> iterator = keyActions.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Action> entry = iterator.next();
            if (entry.getValue() == action) {
                iterator.remove();
            }
        }
        action.reset();
    }

    public void clearAllMaps() {
        keyActions = new HashMap<Integer, Action>();
    }

    public List<String> getMaps(Action action) {
        List<String> maps = new ArrayList<String>();
        for (Map.Entry<Integer, Action> entry : keyActions.entrySet()) {
            if (entry.getValue() == action) {
                maps.add(getKeyName(entry.getKey().intValue()));
            }
        }
        return maps;
    }

    public void resetAllActions() {
        for (Map.Entry<Integer, Action> entry : keyActions.entrySet()) {
            entry.getValue().reset();
        }
    }

    public Set<Action> getAllActions() {
        Set<Action> actions = new HashSet<Action>();
        actions.addAll(keyActions.values());
        return actions;
    }

    public String getKeyName(int code) {
        return Keyboard.getKeyName(code);
    }

    public void update() {
        while (Keyboard.next()) {
            Action action = keyActions.get(Integer.valueOf(Keyboard.getEventKey()));
            if (action != null) {
                if (Keyboard.getEventKeyState()) {
                    action.press();
                } else {
                    action.release();
                }
            }
        }
    }

    public void stop() {
        Keyboard.destroy();
    }

}
