package ru.madzi.games.tools.common.swing;

import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

public class ScreenManager implements ru.madzi.games.tools.graphics.ScreenManager {

    private GraphicsDevice device;

    private JFrame frame;

    private String title;

    private boolean fullscreen;

    public ScreenManager() {
        device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    }

    public DisplayMode[] getCompatibleDisplayModes() {
        return device.getDisplayModes();
    }

    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {
        for (DisplayMode goodMode : device.getDisplayModes()) {
            for (DisplayMode mode : modes) {
                if (displayModesMatch(goodMode, mode)) {
                    return mode;
                }
            }
        }
        return null;
    }

    public DisplayMode getCurrentDisplayMode() {
        return device.getDisplayMode();
    }

    public boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2) {
        return (mode1.getWidth() == mode2.getWidth())
            && (mode1.getHeight() == mode2.getHeight())
            && (mode1.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI 
             || mode2.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI
             || mode1.getBitDepth() == mode2.getBitDepth()) 
            && (mode1.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN
             || mode2.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN
             || mode1.getRefreshRate() == mode2.getRefreshRate());
    }

    public boolean create(DisplayMode mode) {
        this.fullscreen = fullscreen;
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        if (fullscreen) {
            frame.setUndecorated(true);
            device.setFullScreenWindow(frame);
            if (mode != null && device.isDisplayChangeSupported()) {
                try {
                    device.setDisplayMode(mode);
                } catch (IllegalArgumentException ex) {
                    return false;
                }
            }
        } else {
            frame.setVisible(true);
        }
        frame.setSize(mode.getWidth(), mode.getHeight());
        try {
            EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    frame.createBufferStrategy(2);
                }

            });
        } catch (InterruptedException ex) {
            return false;
        } catch (InvocationTargetException ex) {
            return false;
        }
        return true;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public void setTitle(String title) {
        this.title = title;
        if (frame != null) {
            frame.setTitle(title);
        }
    }

    public Graphics2D getGraphics() {
        return frame != null ? (Graphics2D) frame.getGraphics() : null;
    }

    public void update() {
        if (frame != null) {
            BufferStrategy strategy = frame.getBufferStrategy();
            if (!strategy.contentsLost()) {
                strategy.show();
            }
        }
    }

    public JFrame getWindow() {
        return frame;
    }

    public int getWidth() {
        return frame != null ? frame.getWidth() : 0;
    }

    public int getHeight() {
        return frame != null ? frame.getHeight() : 0;
    }

    public String getTitle() {
        return title;
    }

    public void destroy() {
        if (frame != null) {
            frame.dispose();
        }
        if (fullscreen) {
            device.setFullScreenWindow(null);
        }
    }

    public BufferedImage createCompatibleImage(int w, int h, int transparency) {
        return frame != null ? frame.getGraphicsConfiguration().createCompatibleImage(w, h, transparency) : null;
    }

}
