package ru.madzi.games.tools.config;

public class Config {

    private int width = 800;

    private int height = 600;

    private String title = "";

    private boolean fullscreen = false;

    private boolean useSync = false;

    private int syncFps = 100;

    public int getWidth() {
        return width;
    }

    public Config setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Config setHeight(int height) {
        this.height = height;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Config setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public Config setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
        return this;
    }

    public boolean isUseSync() {
        return useSync;
    }

    public Config setUseSync(boolean useSync) {
        this.useSync = useSync;
        return this;
    }

    public int getSyncFps() {
        return syncFps;
    }

    public Config setSyncFps(int syncFps) {
        this.syncFps = syncFps;
        return this;
    }

}
