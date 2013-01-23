package ru.madzi.games.tools.graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import ru.madzi.games.tools.config.ConfigManager;

import static org.lwjgl.opengl.GL11.*;

public class ScreenManager {

    private static final ScreenManager INSTANCE = new ScreenManager();

    private ScreenManager() {}

    public static ScreenManager getInstance() {
        return INSTANCE;
    }

    private boolean useSync = false;

    private int syncFps = 100;

    private long lastFpsTime;

    private int tempFps = 0;

    private int fps = 0;

    private ConfigManager configManager = ConfigManager.getInstance();

    private String title;

    public void init() throws LWJGLException {
        title = configManager.getConfig().getTitle();
        useSync = configManager.getConfig().isUseSync();
        syncFps = configManager.getConfig().getSyncFps();
        Display.setDisplayMode(new DisplayMode(configManager.getConfig().getWidth(), configManager.getConfig().getHeight()));
        Display.setTitle(title);
        Display.setFullscreen(configManager.getConfig().isFullscreen());
        Display.create();
        glClearColor(0, 0, 0, 0);
    }

    public void beforeDraw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    public void afterDraw() {
        Display.update();
        if (useSync) {
            Display.sync(syncFps);
        }
        long newFpsTime = Sys.getTime();
        tempFps++;
        if (newFpsTime > lastFpsTime + Sys.getTimerResolution()) {
            fps = tempFps;
            tempFps = 0;
            lastFpsTime = newFpsTime;
        }
    }

    public int getFps() {
        return fps;
    }

    public boolean isDone() {
        return Display.isCloseRequested();
    }

    public void stop() {
        Display.destroy();
    }

}
