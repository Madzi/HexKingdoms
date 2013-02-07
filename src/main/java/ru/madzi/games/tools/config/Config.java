package ru.madzi.games.tools.config;

import org.lwjgl.input.Keyboard;

public class Config {

    private int width = 800;

    private int height = 600;

    private String title = "";

    private boolean fullscreen = false;

    private boolean useSync = false;

    private int syncFps = 100;

    private int keyEsc = Keyboard.KEY_ESCAPE;

    private int keyFire = Keyboard.KEY_SPACE;

    private int keyLeft = Keyboard.KEY_LEFT;

    private int keyRight = Keyboard.KEY_RIGHT;

    private int keyUp = Keyboard.KEY_UP;

    private int keyDown = Keyboard.KEY_DOWN;

    private int keyLeftFire = Keyboard.KEY_Z;

    private int keyRightFire = Keyboard.KEY_M;

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

    public int getKeyEsc() {
        return keyEsc;
    }

    public Config setKeyEsc(int keyEsc) {
        this.keyEsc = keyEsc;
        return this;
    }

    public int getKeyFire() {
        return keyFire;
    }

    public Config setKeyFire(int keyFire) {
        this.keyFire = keyFire;
        return this;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

    public Config setKeyLeft(int keyLeft) {
        this.keyLeft = keyLeft;
        return this;
    }

    public int getKeyRight() {
        return keyRight;
    }

    public Config setKeyRight(int keyRight) {
        this.keyRight = keyRight;
        return this;
    }

    public int getKeyUp() {
        return keyUp;
    }

    public Config setKeyUp(int keyUp) {
        this.keyUp = keyUp;
        return this;
    }

    public int getKeyDown() {
        return keyDown;
    }

    public Config setKeyDown(int keyDown) {
        this.keyDown = keyDown;
        return this;
    }

    public int getKeyLeftFire() {
        return keyLeftFire;
    }

    public Config setKeyLeftFire(int keyLeftFire) {
        this.keyLeftFire = keyLeftFire;
        return this;
    }

    public int getKeyRightFire() {
        return keyRightFire;
    }

    public Config setKeyRightFire(int keyRightFire) {
        this.keyRightFire = keyRightFire;
        return this;
    }

}
