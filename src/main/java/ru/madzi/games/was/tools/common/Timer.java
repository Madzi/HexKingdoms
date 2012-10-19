package ru.madzi.games.was.tools.common;

import org.lwjgl.Sys;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class Timer {

    public static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
}
