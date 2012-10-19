package ru.madzi.games.was.tools.common;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public abstract class AbstractManager implements Managerable {

    protected boolean error = false;

    public boolean hasError() {
        return error;
    }

}
