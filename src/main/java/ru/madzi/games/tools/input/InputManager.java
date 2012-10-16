package ru.madzi.games.tools.input;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ru.madzi.games.tools.action.Action;
import ru.madzi.games.tools.common.Managerable;

public class InputManager implements Managerable {

    private Map<Device, AbstractDevice> devices = new HashMap<Device, AbstractDevice>();

    private boolean error = false;

    public void map(Device device, Action action, int key) {
        AbstractDevice ad = devices.get(device); 
        if (ad != null) {
            ad.map(action, key);
        }
    }


    public void clearMap(Device device, Action action) {
        AbstractDevice ad = devices.get(device);
        if (ad != null) {
            ad.clearMap(action);
        }
    }

    public void clearMap(Action action) {
        for (AbstractDevice ad : devices.values()) {
            ad.clearMap(action);
        }
    }

    public Set<String> getMaps(Device device, Action action) {
        AbstractDevice ad = devices.get(device);
        return ad != null ? ad.getMaps(action) : Collections.<String>emptySet();
    }

    public Set<String> getMaps(Action action) {
        Set<String> mapSet = new HashSet<String>();
        for (AbstractDevice device : devices.values()) {
            mapSet.addAll(device.getMaps(action));
        }
        return mapSet;
    }

    public void init() {
        KeyboardDevice keyboard = new KeyboardDevice();
        devices.put(Device.KEYBOARD, keyboard);
        keyboard.init();
        error = keyboard.hasError();
    }

    public boolean hasError() {
        return error;
    }

    public void done() {
        for (AbstractDevice device : devices.values()) {
            device.done();
        }
    }

}
