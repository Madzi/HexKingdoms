package ru.madzi.games.tools.graphics;

import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public interface ScreenManager {

    public DisplayMode[] getCompatibleDisplayModes();

    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes);

    public DisplayMode getCurrentDisplayMode();

    public boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2);

    public boolean create(DisplayMode mode);

    public void setFullscreen(boolean fullscreen);

    public void setTitle(String title);

    public Graphics2D getGraphics();

    public void update();

    public JFrame getWindow();

    public int getWidth();

    public int getHeight();

    public String getTitle();

    public void destroy();

    public BufferedImage createCompatibleImage(int w, int h, int transparency);

}
