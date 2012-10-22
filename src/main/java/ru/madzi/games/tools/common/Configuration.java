package ru.madzi.games.tools.common;

public class Configuration {

    private String title = "Core";

    private boolean fullscreen = false;

    private int width = 800;

    private int height = 600;

    public String getTitle() {
        return title;
    }

    public Configuration setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public Configuration setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Configuration setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Configuration setHeight(int height) {
        this.height = height;
        return this;
    }

}
