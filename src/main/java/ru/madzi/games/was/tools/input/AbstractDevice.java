package ru.madzi.games.was.tools.input;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ru.madzi.games.tools.action.Action;
import ru.madzi.games.was.tools.common.Managerable;

public abstract class AbstractDevice implements Managerable {

    protected Action[] maps;

    protected boolean error = false;

    public boolean hasError() {
        return error;
    }

    public abstract String getName();

    public void map(Action action, int key) {
        maps[key] = action;
    }

    public void clearMap(Action action) {
        for (int key = 0; key < maps.length; ++key) {
            if (maps[key] == action) {
                maps[key] = null;
            }
        }
    }

    public Set<String> getMaps(Action action) {
        Set<String> mapNames = new HashSet<String>();
        for (int key = 0; key < maps.length; ++key) {
            if (maps[key] == action) {
                mapNames.add(getKeyName(key));
            }
        }
        return mapNames;
    }

    public void clearAllMaps() {
        for (int key = 0; key < maps.length; ++key) {
            if (maps[key] != null) {
                maps[key] = null;
            }
        }
    }

    public void resetAllActions() {
        for (int key = 0; key < maps.length; ++key) {
            if (maps[key] != null) {
                maps[key].reset();
            }
        }
    }

    public abstract String getKeyName(int key);

    public Map<Integer, String> getAllKeyName() {
        Map<Integer, String> mapNames = new HashMap<Integer, String>(maps.length);
        for (int key = 0; key < maps.length; ++key) {
            mapNames.put(Integer.valueOf(key), getKeyName(key));
        }
        return mapNames;
    }

}
